import { Component, Prop, h } from '@stencil/core';

@Component({
  tag: 'add-comment',
  styleUrl: 'add-comment.css',
  shadow: true,
})
export class MyComponent {
  @Prop() endpoint: string;
  @Prop() trackId: number;

  handleSubmit = (event: Event) => {
    event.preventDefault();
    const formData = {
      trackId: this.trackId,
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


  render() {
    return (
      <form onSubmit={this.handleSubmit} class="container">
        <input type="hidden" name="trackId" value={this.trackId} id="trackId" onInput={this.handleTrackIdChange} />
        <div class="form-group">
          <label htmlFor="content" class="form-label">
            Comentario
          </label>
          <textarea class="form-control" id="content" name="content" />
        </div>
        <label htmlFor="score" class="form-label">
          Puntuación
        </label>
        <input type="range" class="form-range" min="0" max="5" id="score" name="score" />
        <div class="form-group">
          <label htmlFor="author" class="form-label">
            Autor
          </label>
          <input type="text" class="form-control" name="author" id="author" placeholder="Nombre" />
        </div>
        <div class="form-group">
          <label htmlFor="date" class="form-label">
            Fecha
          </label>
          <input type="text" class="form-control" name="date" id="date" placeholder="Nombre" />
        </div>
        <button type="submit" class="btn btn-primary">
          Enviar
        </button>
      </form>
    );
  }
}
