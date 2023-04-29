import { Component, Prop, h } from '@stencil/core';

@Component({
  tag: 'add-comment',
  styleUrl: 'add-comment.css',
  shadow: true,
})
export class MyComponent {
  @Prop() endpoint: string;
  @Prop() trackId: number;
  @Prop() content: string;
  @Prop() score: number;
  @Prop() author: string;
  @Prop() date: string;

  handleSubmit = (event: Event) => {
    event.preventDefault();
    const formData = {
      trackId: this.trackId,
      content: this.content,
      score: this.score,
      author: this.author,
      date: this.date,
    };
    console.log(formData);
    fetch(this.endpoint, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
        // do something with the server response
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  handleTrackIdChange = (event: Event) => {
    this.trackId = parseInt((event.target as HTMLInputElement).value, 10);
  };

  handleContentChange = (event: Event) => {
    this.content = (event.target as HTMLTextAreaElement).value;
  };

  handleScoreChange = (event: Event) => {
    this.score = parseInt((event.target as HTMLInputElement).value, 10);
  };

  handleAuthorChange = (event: Event) => {
    this.author = (event.target as HTMLInputElement).value;
  };

  handleDateChange = (event: Event) => {
    this.date = (event.target as HTMLInputElement).value;
  };

  render() {
    return (
      <form onSubmit={this.handleSubmit} class="container">
        <input type="hidden" name="trackId" value={this.trackId} id="trackId" onInput={this.handleTrackIdChange} />
        <div class="form-group">
          <label htmlFor="content" class="form-label">
            Comentario
          </label>
          <textarea class="form-control" id="content" name="content" value={this.content} onInput={this.handleContentChange} />
        </div>
        <label htmlFor="score" class="form-label">
          Puntuación
        </label>
        <input type="range" class="form-range" min="0" max="5" id="score" name="score" value={this.score} onInput={this.handleScoreChange} />
        <div class="form-group">
          <label htmlFor="author" class="form-label">
            Autor
          </label>
          <input type="text" class="form-control" name="author" id="author" placeholder="Nombre" value={this.author} onInput={this.handleAuthorChange} />
        </div>
        <div class="form-group">
          <label htmlFor="date" class="form-label">
            Fecha
          </label>
          <input type="text" class="form-control" name="date" id="date" placeholder="Nombre" value={this.date} onInput={this.handleDateChange} />
        </div>
        <button type="submit" class="btn btn-primary">
          Enviar
        </button>
      </form>
    );
  }
}
