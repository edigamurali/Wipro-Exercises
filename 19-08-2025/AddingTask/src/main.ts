import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { HomeComponent } from './app/home/home';

bootstrapApplication(HomeComponent, appConfig).catch((err) => console.error(err));
