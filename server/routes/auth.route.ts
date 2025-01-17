import { Router } from 'express';
import bcrypt from 'bcrypt';
import prisma from '../utils/prismaClient';

const router = Router();

router.post('/signup', async (req, res) => {
    
    const { email, name, password, role } = req.body;

    try {
        // Check if the username already exists
        const existingUser = await prisma.user.findFirst({
            where: {
                email
            },
        });

        if (existingUser) {
            return res.status(400).json({ status: 400, message: 'Username already exists', payload: null });
        }

        // Hash the password
        const hashedPassword = await bcrypt.hash(password, 10);

        // Create the new user
        const newUser = await prisma.user.create({
            data: {
                email,
                name,
                password: hashedPassword,
                role
            },
        });


        res.status(201).json({ message: 'User created successfully', status: 201, payload: newUser });
    } catch (error) {
        console.error('Error creating user:', error);
        res.status(500).json({ status: 500, message: 'Internal server error', payload: null });
    }
});

router.post('/login', async (req, res) => {
    const { email, password } = req.body;
    try {

        if (!email || !password) {
            throw new Error("Required email, password")
        }
        const user = await prisma.user.findUnique({
            where: {
                email
            }
        })
        if (!user) {
            throw new Error("User not found")
        } else {
            const isOk = await bcrypt.compare(password, user.password);
            if (isOk) {
                res.status(200).json({
                    message: "Login successful",
                    status: 200,
                    payload: user
                })
            }
            else {
                throw new Error("Invalid password")
            }
        }

    }catch (error) {
        console.error('Error logging in:', error);
        res.status(500).json({ status: 500, message: 'Internal server error', payload: null });
    }
})

export default router;