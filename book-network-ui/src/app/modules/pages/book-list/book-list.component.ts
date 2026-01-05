import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageResponseBookResponse } from 'src/app/api/models/page-response-book-response';
import { BookService } from 'src/app/api/services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  bookResponse: PageResponseBookResponse = {};
  private bookservice = inject(BookService);
  private router = inject(Router);
  page: number = 0;
  size: number = 5;

  ngOnInit(): void {
    this.findAllBooks();
  }

  findAllBooks() {
    this.bookservice.findAllBooks({
      page: this.page,
      size: this.size
    }).subscribe({
      next: (books) => {
        this.bookResponse = books;
      }
    })
  }

}
