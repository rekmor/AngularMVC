import { Component, OnInit } from '@angular/core';
import {CarService} from '../shared/car.service'
import {NgForm} from '@angular/forms'



@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  constructor(private carService : CarService ) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm) {
    if (form != null)
      form.reset();
    this.carService.selectedCar = {
      id: null,
      name: '',
      model: '',
      year: null,
      price: null
      
    }
  }

  onSubmit(form: NgForm) {
     if(form.value.id == null ){
      this.carService.postCar(form.value)
       .subscribe( data => {
        this.resetForm(form);
        this.carService.getCarList()
       })
      }
      else{
        this.carService.putCar(form.value.id,form.value)
        .subscribe( data => {
         this.resetForm(form);
         this.carService.getCarList()
        })
      }
    }

    


}


