import { Observable, of } from "rxjs";

export interface Pizza {
    id: string;
    name: string;
    price: number;
  }
  
  const getPizzas$: Observable<Pizza[]> = of([
    { id: "j8P9sz", name: "Pepperoni", price: 899 },
    { id: "tMot06", name: "Supreme", price: 999 },
    { id: "x9sD3g", name: "Sizzler", price: 899 },
  ]);