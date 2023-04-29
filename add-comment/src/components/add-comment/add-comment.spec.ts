import { newSpecPage } from '@stencil/core/testing';
import { MyComponent } from './add-comment';

describe('add-comment', () => {
  it('renders', async () => {
    const { root } = await newSpecPage({
      components: [MyComponent],
      html: '<add-comment></add-comment>',
    });
    expect(root).toEqualHtml(`
      <add-comment>
        <mock:shadow-root>
          <div>
            Hello, World! I'm
          </div>
        </mock:shadow-root>
      </add-comment>
    `);
  });

  it('renders with values', async () => {
    const { root } = await newSpecPage({
      components: [MyComponent],
      html: `<add-comment first="Stencil" last="'Don't call me a framework' JS"></add-comment>`,
    });
    expect(root).toEqualHtml(`
      <add-comment first="Stencil" last="'Don't call me a framework' JS">
        <mock:shadow-root>
          <div>
            Hello, World! I'm Stencil 'Don't call me a framework' JS
          </div>
        </mock:shadow-root>
      </add-comment>
    `);
  });
});
