import { Config } from '@stencil/core';

export const config: Config = {
  namespace: 'add-comment',
  outputTargets: [
    {
      type: 'dist',
      esmLoaderPath: '../loader',
    },
    {
      type: 'dist-custom-elements',
    },
    {
      type: 'docs-readme',
    },
    {
      type: 'www',
      baseUrl: 'http://localhost:8000',
      serviceWorker: null, // disable service workers
    },
  ],
};
