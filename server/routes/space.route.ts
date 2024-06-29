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
router.put('/updatespace/:id', async (req: Request<any, any>, res: Response) => {
    const spaceId = parseInt(req.params.id);
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

    // Validate required fields
    if (!name || !description || !address || !location || !ownerId || !status || !price || !size || !type || !image || !performanceMetricId) {
        return res.status(400).json({ error: "Required all the fields" });
    }

    try {
        const updatedSpace = await prisma.space.update({
            where: { id: spaceId },
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
        res.status(200).json(updatedSpace);
    } catch (error) {
        console.error('Error updating space:', error);
        res.status(500).json({ error: 'Internal server error' });
    }
});

export default router;