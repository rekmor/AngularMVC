import { Component, OnInit } from '@angular/core';
import {CarService} from '../shared/car.service'
import {Car} from '../shared/car.model'

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  constructor(private carService: CarService) { }

  ngOnInit() {
    this.carService.getCarList();
  }

  showForEdit(c: Car) {
    this.carService.selectedCar = Object.assign({}, c);
  }

  onDelete(id: number) {
    if (confirm('Are you sure to delete this record ?') == true) {
      this.carService.deleteCar(id)
      .subscribe(x => {
        this.carService.getCarList();
      })
    }
  }
}
