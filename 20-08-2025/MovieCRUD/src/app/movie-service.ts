import { Injectable } from '@angular/core';
import { Movie } from './movie';
@Injectable({
  providedIn: 'root',
})
export class MovieService {
  movieList: Movie[] = [
    { movieId: 100, movieName: 'RRR', language: 'Telugu', imdbRating: 9.5 },
    { movieId: 101, movieName: 'Bahubali', language: 'Telugu', imdbRating: 9.6 },
    { movieId: 103, movieName: 'Chavva', language: 'Hindi', imdbRating: 9.0 },
    { movieId: 100, movieName: 'Cooli', language: 'Tamil', imdbRating: 8.0 },
  ];

  getMovie(): Movie[] {
    return this.movieList;
  }
}
