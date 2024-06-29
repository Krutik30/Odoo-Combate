import express, { Response, Request } from 'express';
import dotenv from 'dotenv';
dotenv.config();

const app = express();
const port = process.env.PORT || 3000;

app.get('/', (req: Request, res: Response) => {
    res.send('Hello World');
})

app.listen(3000, () => {
    console.log(`Server is running on port ${port}`);
})