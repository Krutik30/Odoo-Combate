import express, { Response, Request } from 'express';
import dotenv from 'dotenv';
import { PrismaClient } from '@prisma/client';
dotenv.config();

const app = express();
const port = process.env.PORT || 3000;

app.get('/',async (req: Request, res: Response) => {
    const prisma = new PrismaClient();

    const users = await prisma.user.findMany();

    console.log(users);
    res.send('Hello World');
})

app.listen(3000, () => {
    console.log(`Server is running on port ${port}`);
})