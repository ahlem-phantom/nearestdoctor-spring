import { Component, OnInit } from '@angular/core';
import { Observable, interval } from 'rxjs';
import { ChatService } from '../core/services/chat/chat.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Chat } from '../core/models/chat';
import { User } from '../core/models/user';

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrls: ['./chatbot.component.css']
})
export class ChatbotComponent implements OnInit {
  addForm: FormGroup;
  formValue: string;
  chat: Chat;
  user: User;
  messages: Chat[] = [];

  constructor(public chatService: ChatService, private fb: FormBuilder) { }

  ngOnInit() {
    interval(1000).subscribe((val) => {  this.getMessages() });
     // this.getMessages();
    this.addForm = this.fb.group({
      messageSent : [''],
     });
     
  }

  getMessages(): void {
		this.chatService.getChats(3).subscribe(messages=> { this.messages = messages
      console.log(this.messages);
     });

     
	}

  trackByFn(index, item) {
    return index; // or item.id
  }
  
  sendMessage() {
    console.log(this.addForm.getRawValue());
    this.chat = this.addForm.getRawValue();
    this.user= new User();
    this.user.id = 3;
    this.chat.user = this.user;
    console.log(this.chat);
    this.chatService.sendMessage(this.chat).subscribe(() =>  this.ngOnInit());

  }

  


}
