import { Component } from '@angular/core';
import { FruitComponent } from '../fruit/fruit';
import { IFruit } from '../ifruit';

@Component({
  selector: 'app-exe1-home',
  standalone: true,
  imports: [FruitComponent],
  templateUrl: './exe1-home.html',
  styleUrls: ['./exe1-home.css'],
})
export class Exe1Home {
  remove(name: string) {
    this.fruits = this.fruits.filter((fruit) => fruit.name !== name);
  }
  fruits: IFruit[] = [
    {
      name: 'Mango',
      image: 'https://upload.wikimedia.org/wikipedia/commons/9/90/Hapus_Mango.jpg',
      description: 'A tropical fruit with a sweet, juicy taste and smooth golden flesh.',
    },
    {
      name: 'Grapes',
      image:
        'https://th.bing.com/th/id/OIP.Tm0_Yd8Hg_xOPV4F2dnH0QHaFj?w=200&h=200&c=10&o=6&pid=genserp&rm=2',
      description:
        'Small, juicy fruits that grow in clusters and are eaten fresh or used for wine.',
    },
    {
      name: 'Pineapple',
      image: 'https://upload.wikimedia.org/wikipedia/commons/c/cb/Pineapple_and_cross_section.jpg',
      description: 'A tropical fruit with a spiky skin and sweet, tangy yellow flesh.',
    },
    {
      name: 'Strawberry',
      image: 'https://upload.wikimedia.org/wikipedia/commons/2/29/PerfectStrawberry.jpg',
      description: 'A red, heart-shaped fruit with tiny seeds and a sweet, slightly tart flavor.',
    },
    {
      name: 'Watermelon',
      image:
        'https://th.bing.com/th/id/OIP.XOrFzWs2DSTQLYwbRVIdlwHaEK?w=274&h=180&c=7&r=0&o=7&pid=1.7&rm=3',
      description: 'A large fruit with green rind, juicy red flesh, and black seeds.',
    },
    {
      name: 'Papaya',
      image:
        'https://tse4.mm.bing.net/th/id/OIP.ffQktiWiyLHxI4eMyNXb1wHaEo?rs=1&pid=ImgDetMain&o=7&rm=3',
      description: 'A tropical fruit with orange flesh, black seeds, and a soft, sweet flavor.',
    },
    {
      name: 'Kiwi',
      image: 'https://upload.wikimedia.org/wikipedia/commons/d/d3/Kiwi_aka.jpg',
      description: 'A small fruit with fuzzy brown skin and bright green, tangy-sweet flesh.',
    },
    {
      name: 'Apple',
      image: 'https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg',
      description: 'A sweet, crisp fruit that comes in red, green, and yellow varieties.',
    },
    {
      name: 'Banana',
      image: 'https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg',
      description: 'A long, curved fruit with a soft interior and yellow peel when ripe.',
    },
    {
      name: 'Orange',
      image: 'https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg',
      description: 'A juicy citrus fruit known for its tangy flavor and vitamin C content.',
    },
  ];
}
