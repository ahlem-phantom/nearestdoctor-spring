import { User } from "./user";

export interface Chat {
   messageSent: string;
   messageReceived: string;
   user : User;
} 