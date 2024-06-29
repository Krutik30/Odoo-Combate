import prisma from '../utils/prismaClient';
import { Router, Request, Response } from 'express';

const router = Router();




router.post('/createspaces', async (req: Request<any, any>, res: Response) => {
    const {
        name,
        description,
        address,
        location,
        ownerId,
        status,
        price,
        size,
        type,
        image,
        performanceMetricId,
        
    } = req.body;
    if (!name || !description || !address || !location || !ownerId || !status || !price || !size || !size || !type ||!image ||!performanceMetricId) {
        throw new Error("Required all the fields ")
    }
    try {
        const newSpace = await prisma.space.create({
            data: {
                name,
                description,
                address,
                location,
                ownerId,  
                status,
                price,
                size,
                type,
                image,
                performanceMetricId,
               
            },
        });
        res.status(201).json(newSpace);
    } catch (error) {
        console.error('Error creating space:', error);
        res.status(500).json({ error: 'Internal server error' });
    }
});

export default router;