import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Chat } from '../../models/chat';
@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private chatUrl = 'http://localhost:8080/server/chat';  // URL to REST API

  constructor(private http: HttpClient) { }

 /** GET users from the server */
 getChats(id: number): Observable<Chat[]> {
  const url = `${this.chatUrl}/get-chats/${id}`;
  return this.http.get<Chat[]>(url);
}

/** GET user by id. Will 404 if id not found */
getChat(id: number): Observable<any> {
  const url = `${this.chatUrl}/get-chat/${id}`;
  return this.http.get<Chat>(url);
}

/** POST: add a new user to the server */
sendMessage(chat: Chat) {
  return this.http.post(this.chatUrl + '/send-msg', chat);
}

/** PUT: update the user on the server */
updateChat(id ,chat: Chat) {
  return this.http.put(this.chatUrl + `/update-chat/${id}`, chat);
}

/** DELETE: delete the user from the server */
deleteChat(id: number) {
  return this.http.delete(this.chatUrl + `/delete-chat/${id}`);
 }

}