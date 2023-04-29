import { r as registerInstance, h } from './index-6305435d.js';

const addCommentCss = ":host{display:block}";

const MyComponent = class {
  constructor(hostRef) {
    registerInstance(this, hostRef);
    this.handleSubmit = (event) => {
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
    this.handleTrackIdChange = (event) => {
      this.trackId = parseInt(event.target.value, 10);
    };
    this.handleContentChange = (event) => {
      this.content = event.target.value;
    };
    this.handleScoreChange = (event) => {
      this.score = parseInt(event.target.value, 10);
    };
    this.handleAuthorChange = (event) => {
      this.author = event.target.value;
    };
    this.handleDateChange = (event) => {
      this.date = event.target.value;
    };
    this.endpoint = undefined;
    this.trackId = undefined;
    this.content = undefined;
    this.score = undefined;
    this.author = undefined;
    this.date = undefined;
  }
  render() {
    return (h("form", { onSubmit: this.handleSubmit, class: "container" }, h("input", { type: "hidden", name: "trackId", value: this.trackId, id: "trackId", onInput: this.handleTrackIdChange }), h("div", { class: "form-group" }, h("label", { htmlFor: "content", class: "form-label" }, "Comentario"), h("textarea", { class: "form-control", id: "content", name: "content", value: this.content, onInput: this.handleContentChange })), h("label", { htmlFor: "score", class: "form-label" }, "Puntuaci\u00F3n"), h("input", { type: "range", class: "form-range", min: "0", max: "5", id: "score", name: "score", value: this.score, onInput: this.handleScoreChange }), h("div", { class: "form-group" }, h("label", { htmlFor: "author", class: "form-label" }, "Autor"), h("input", { type: "text", class: "form-control", name: "author", id: "author", placeholder: "Nombre", value: this.author, onInput: this.handleAuthorChange })), h("div", { class: "form-group" }, h("label", { htmlFor: "date", class: "form-label" }, "Fecha"), h("input", { type: "text", class: "form-control", name: "date", id: "date", placeholder: "Nombre", value: this.date, onInput: this.handleDateChange })), h("button", { type: "submit", class: "btn btn-primary" }, "Enviar")));
  }
};
MyComponent.style = addCommentCss;

export { MyComponent as add_comment };

//# sourceMappingURL=add-comment.entry.js.map