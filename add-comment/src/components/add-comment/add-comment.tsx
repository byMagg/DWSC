import { Component, Prop, h } from '@stencil/core';

@Component({
  tag: 'add-comment',
  styleUrl: 'add-comment.css',
  shadow: true,
})
export class AddComment {
  @Prop() endpoint: string;
  @Prop() trackid: number;

  render() {
    return (
      <form action={this.endpoint} class="container" method='POST'>
        <input type="hidden" class="form-control" name="trackid" id="trackid" value={this.trackid} />
        <div class="form-group">
          <label htmlFor="content" class="form-label">
            Comentario
          </label>
          <input type="text" class="form-control" name="content" id="content" />
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
