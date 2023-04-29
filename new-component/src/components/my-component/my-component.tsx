import { Component, Prop, h } from '@stencil/core';

@Component({
  tag: 'add-comment',
  styleUrl: 'add-comment.css',
  shadow: true,
})
export class MyComponent {

  @Prop() firstname: string;
  @Prop() surname: string;

  render() {
    return <div>My name is {this.firstname} {this.surname}</div>;
  }
}
