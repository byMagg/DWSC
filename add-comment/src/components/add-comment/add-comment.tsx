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
          <input type="text" class="form-control" name="author" id="author" placeholder="Autor" />
        </div>
        <div class="form-group">
          <input type="text" class="form-control" name="content" id="content" placeholder='Añade un comentario' />
        </div>
        <div class="form-group">
          <label htmlFor="score" class="form-label">
            Puntuación
          </label>
          <input type="range" class="form-range" min="0" max="5" id="score" name="score" />
        </div>
        <button type="submit" class="btn btn-primary">
          Enviar
        </button>
      </form>
    );
  }
}
