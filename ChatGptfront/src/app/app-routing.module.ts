import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatbootComponent } from './chatboot/chatboot.component';

const routes: Routes = [
  {
    path: 'chatboot',
    component: ChatbootComponent
  },
  {
    path: '',
    component: ChatbootComponent
  }

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
