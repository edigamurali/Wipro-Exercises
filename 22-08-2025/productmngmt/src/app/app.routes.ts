import { Routes } from '@angular/router';
import { Productlist } from './productlist/productlist';
import { Productadd } from './productadd/productadd';
import { Productedit } from './productedit/productedit';
import { Productdelete } from './productdelete/productdelete';
import { Ordercreatecomp } from './ordercreatecomp/ordercreatecomp';
import { Orderhistorycomp } from './orderhistorycomp/orderhistorycomp';

export const routes: Routes = [
  { path: '', component: Productlist },
  { path: 'productlist', component: Productlist },
  { path: 'productadd', component: Productadd },
  { path: 'productedit/:id', component: Productedit },
  { path: 'productdelete/:id', component: Productdelete },

  { path: 'order', component: Ordercreatecomp },
  { path: 'orders', component: Orderhistorycomp },
  { path: '', redirectTo: 'productlist', pathMatch: 'full' },
];
