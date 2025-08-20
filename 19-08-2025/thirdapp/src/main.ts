import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Exe1Home } from './app/exe1-home/exe1-home';
import { Exe2NgClass } from './app/exe2-ng-class/exe2-ng-class';
import { Exe4ngstyle } from './app/exe4ngstyle/exe4ngstyle';

bootstrapApplication(Exe1Home, appConfig).catch((err) => console.error(err));
