import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule, CanActivate } from '@angular/router';
import { ChatbotComponent } from './chatbot/chatbot.component';

const routes: Routes =[
  {
    path: '',
    redirectTo: 'chat',
    pathMatch: 'full',
  },
{
  path: 'chat',
  component: ChatbotComponent,
},

];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
