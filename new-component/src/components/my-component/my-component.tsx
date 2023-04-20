import { Component, Prop, h } from '@stencil/core';

@Component({
  tag: 'my-component',
  styleUrl: 'my-component.css',
  shadow: true,
})
export class MyComponent {

  @Prop() firstname: string;
  @Prop() surname: string;

  render() {
    return <div>My name is {this.firstname} {this.surname}</div>;
  }
}
