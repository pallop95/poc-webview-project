import { SignInComponent } from './components/sign-in/sign-in.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  // one-jwt
  { path: 'login/:oneJwt', component: SignInComponent }
  
  // access-deny
  // { path: 'access-deny', component: MyComponent }

  // pass
  // { path: '', component: Dashboard }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
