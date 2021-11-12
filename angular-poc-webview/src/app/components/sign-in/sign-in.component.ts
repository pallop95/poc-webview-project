import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  oneJwt: string | null = '';
  
  constructor(
    private route: ActivatedRoute) {}
    
    ngOnInit(): void {
      this.oneJwt = this.route.snapshot.paramMap.get('oneJwt');
    }

}
