/* eslint-disable */
/* tslint:disable */
/**
 * This is an autogenerated file created by the Stencil compiler.
 * It contains typing information for all components that exist in this project.
 */
import { HTMLStencilElement, JSXBase } from "@stencil/core/internal";
export namespace Components {
    interface AddComment {
        "author": string;
        "content": string;
        "date": string;
        "endpoint": string;
        "score": number;
        "trackId": number;
    }
}
declare global {
    interface HTMLAddCommentElement extends Components.AddComment, HTMLStencilElement {
    }
    var HTMLAddCommentElement: {
        prototype: HTMLAddCommentElement;
        new (): HTMLAddCommentElement;
    };
    interface HTMLElementTagNameMap {
        "add-comment": HTMLAddCommentElement;
    }
}
declare namespace LocalJSX {
    interface AddComment {
        "author"?: string;
        "content"?: string;
        "date"?: string;
        "endpoint"?: string;
        "score"?: number;
        "trackId"?: number;
    }
    interface IntrinsicElements {
        "add-comment": AddComment;
    }
}
export { LocalJSX as JSX };
declare module "@stencil/core" {
    export namespace JSX {
        interface IntrinsicElements {
            "add-comment": LocalJSX.AddComment & JSXBase.HTMLAttributes<HTMLAddCommentElement>;
        }
    }
}