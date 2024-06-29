import express, { Response, Request } from 'express';
import dotenv from 'dotenv';
import morgan from 'morgan';
import cors from 'cors';
import authRoutes from './routes/auth.route'; 
import userRoutes from './routes/user.route'; 
import bodyParser from 'body-parser';
dotenv.config();

const app = express();
const port = process.env.PORT || 3000;

app.use(express.json());

var corsOptions = {
    origin: ['http://localhost:5173', 'http://localhost:5174', 'https://expence-tracker-hackdspring.vercel.app'],
    methods: ['GET', 'POST', 'PUT', 'DELETE'],
    allowedHeaders: ['Content-Type', 'authorization'],
    credentials: true
};


// app.use(express.json());
app.use(cors(corsOptions));
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json())
app.use(express.json());
app.use(morgan('dev'));

app.use('/auth', authRoutes);
app.use('/users', userRoutes);


app.get('/', (req: Request, res: Response) => {
    res.send('Hello World');
})

app.listen(3000, () => {
    console.log(`Server is running on port ${port}`);
})