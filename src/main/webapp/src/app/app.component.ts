import { Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Организации';

  data: any = {};

  onSubmit() {
    alert(JSON.stringify(this.data));
  }

}
