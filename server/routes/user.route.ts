import { Router } from 'express';
import prisma from '../utils/prismaClient';

const router = Router();

router.post('/add_detail', async (req, resp) => {
    const { email, role, details } = req.body;

    try {
        console.log('Request received:', { email, role, details });
        //check the role is correct or not
        const user = await prisma.user.findUnique({
            where: { email }
        });

        if (!user) {
            return resp.status(404).json({ error: 'User not found' });
        }

        // Validate the role
        if (user.role !== role) {
            return resp.status(400).json({ error: 'Role mismatch' });
        }
       
        let createdDetail;
        if (role === 'Admin') {
            createdDetail = await prisma.adminDetails.create({
                data: {
                    user_id: user.id,
                    ...details

                },
            })
        }
        else if(role === 'Advertiser'){
            createdDetail = await prisma.advertiserDetails.create({
                data: {
                    user_id:user.id,
                    ...details
                },
            })
        }
        else if (role==='Owner'){
             createdDetail =  await prisma.spaceOwnerDetails.create({
                data: {
                    user_id:user.id,
                    ...details
                }
            })
        }
        resp.status(201).json({ message: 'Detail created successfully', createdDetail })
    }
    catch(error){
        console.log(error);
        resp.status(500).json({error:'Internal server error'})
    }
    finally {
        await prisma.$disconnect();
    }

});

export default router;


