const t="add-comment";let n;let e;let s=false;let o=false;const l=(t,n="")=>{{return()=>{}}};const c=(t,n)=>{{return()=>{}}};const i="{visibility:hidden}.hydrated{visibility:inherit}";const f={};const r=t=>t!=null;const u=t=>{t=typeof t;return t==="object"||t==="function"};function a(t){var n,e,s;return(s=(e=(n=t.head)===null||n===void 0?void 0:n.querySelector('meta[name="csp-nonce"]'))===null||e===void 0?void 0:e.getAttribute("content"))!==null&&s!==void 0?s:undefined}const d=(t,n,...e)=>{let s=null;let o=false;let l=false;const c=[];const i=n=>{for(let e=0;e<n.length;e++){s=n[e];if(Array.isArray(s)){i(s)}else if(s!=null&&typeof s!=="boolean"){if(o=typeof t!=="function"&&!u(s)){s=String(s)}if(o&&l){c[c.length-1].t+=s}else{c.push(o?h(null,s):s)}l=o}}};i(e);if(n){{const t=n.className||n.class;if(t){n.class=typeof t!=="object"?t:Object.keys(t).filter((n=>t[n])).join(" ")}}}const f=h(t,null);f.o=n;if(c.length>0){f.l=c}return f};const h=(t,n)=>{const e={i:0,u:t,t:n,h:null,l:null};{e.o=null}return e};const p={};const y=t=>t&&t.u===p;const $=(t,n)=>{if(t!=null&&!u(t)){if(n&2){return parseFloat(t)}if(n&1){return String(t)}return t}return t};const m=(t,n,e)=>{const s=ft.ce(n,e);t.dispatchEvent(s);return s};const b=new WeakMap;const w=(t,n,e)=>{let s=lt.get(t);if(ut&&e){s=s||new CSSStyleSheet;if(typeof s==="string"){s=n}else{s.replaceSync(n)}}else{s=n}lt.set(t,s)};const S=(t,n,e,s)=>{var o;let l=v(n);const c=lt.get(l);t=t.nodeType===11?t:it;if(c){if(typeof c==="string"){t=t.head||t;let n=b.get(t);let e;if(!n){b.set(t,n=new Set)}if(!n.has(l)){{{e=it.createElement("style");e.innerHTML=c}const n=(o=ft.p)!==null&&o!==void 0?o:a(it);if(n!=null){e.setAttribute("nonce",n)}t.insertBefore(e,t.querySelector("link"))}if(n){n.add(l)}}}else if(!t.adoptedStyleSheets.includes(c)){t.adoptedStyleSheets=[...t.adoptedStyleSheets,c]}}return l};const g=t=>{const n=t.$;const e=t.m;const s=n.i;const o=l("attachStyles",n.S);const c=S(e.shadowRoot?e.shadowRoot:e.getRootNode(),n);if(s&10){e["s-sc"]=c;e.classList.add(c+"-h")}o()};const v=(t,n)=>"sc-"+t.S;const j=(t,n,e,s,o,l)=>{if(e!==s){let c=nt(t,n);n.toLowerCase();if(n==="class"){const n=t.classList;const o=k(e);const l=k(s);n.remove(...o.filter((t=>t&&!l.includes(t))));n.add(...l.filter((t=>t&&!o.includes(t))))}else{const i=u(s);if((c||i&&s!==null)&&!o){try{if(!t.tagName.includes("-")){const o=s==null?"":s;if(n==="list"){c=false}else if(e==null||t[n]!=o){t[n]=o}}else{t[n]=s}}catch(t){}}if(s==null||s===false){if(s!==false||t.getAttribute(n)===""){{t.removeAttribute(n)}}}else if((!c||l&4||o)&&!i){s=s===true?"":s;{t.setAttribute(n,s)}}}}};const M=/\s/;const k=t=>!t?[]:t.split(M);const C=(t,n,e,s)=>{const o=n.h.nodeType===11&&n.h.host?n.h.host:n.h;const l=t&&t.o||f;const c=n.o||f;{for(s in l){if(!(s in c)){j(o,s,l[s],undefined,e,n.i)}}}for(s in c){j(o,s,l[s],c[s],e,n.i)}};const O=(t,e,o,l)=>{const c=e.l[o];let i=0;let f;let u;if(c.t!==null){f=c.h=it.createTextNode(c.t)}else{f=c.h=it.createElement(c.u);{C(null,c,s)}if(r(n)&&f["s-si"]!==n){f.classList.add(f["s-si"]=n)}if(c.l){for(i=0;i<c.l.length;++i){u=O(t,c,i);if(u){f.appendChild(u)}}}}return f};const P=(t,n,s,o,l,c)=>{let i=t;let f;if(i.shadowRoot&&i.tagName===e){i=i.shadowRoot}for(;l<=c;++l){if(o[l]){f=O(null,s,l);if(f){o[l].h=f;i.insertBefore(f,n)}}}};const U=(t,n,e,s,o)=>{for(;n<=e;++n){if(s=t[n]){o=s.h;o.remove()}}};const x=(t,n,e,s)=>{let o=0;let l=0;let c=n.length-1;let i=n[0];let f=n[c];let r=s.length-1;let u=s[0];let a=s[r];let d;while(o<=c&&l<=r){if(i==null){i=n[++o]}else if(f==null){f=n[--c]}else if(u==null){u=s[++l]}else if(a==null){a=s[--r]}else if(E(i,u)){N(i,u);i=n[++o];u=s[++l]}else if(E(f,a)){N(f,a);f=n[--c];a=s[--r]}else if(E(i,a)){N(i,a);t.insertBefore(i.h,f.h.nextSibling);i=n[++o];a=s[--r]}else if(E(f,u)){N(f,u);t.insertBefore(f.h,i.h);f=n[--c];u=s[++l]}else{{d=O(n&&n[l],e,l);u=s[++l]}if(d){{i.h.parentNode.insertBefore(d,i.h)}}}}if(o>c){P(t,s[r+1]==null?null:s[r+1].h,e,s,l,r)}else if(l>r){U(n,o,c)}};const E=(t,n)=>{if(t.u===n.u){return true}return false};const N=(t,n)=>{const e=n.h=t.h;const o=t.l;const l=n.l;const c=n.t;if(c===null){{{C(t,n,s)}}if(o!==null&&l!==null){x(e,o,n,l)}else if(l!==null){if(t.t!==null){e.textContent=""}P(e,null,n,l,0,l.length-1)}else if(o!==null){U(o,0,o.length-1)}}else if(t.t!==c){e.data=c}};const T=(t,s)=>{const o=t.m;const l=t.g||h(null,null);const c=y(s)?s:d(null,null,s);e=o.tagName;c.u=null;c.i|=4;t.g=c;c.h=l.h=o.shadowRoot||o;{n=o["s-sc"]}N(l,c)};const A=(t,n)=>{if(n&&!t.v&&n["s-p"]){n["s-p"].push(new Promise((n=>t.v=n)))}};const F=(t,n)=>{{t.i|=16}if(t.i&4){t.i|=512;return}A(t,t.j);const e=()=>L(t,n);return mt(e)};const L=(t,n)=>{const e=l("scheduleUpdate",t.$.S);const s=t.M;let o;e();return I(o,(()=>R(t,s,n)))};const R=async(t,n,e)=>{const s=t.m;const o=l("update",t.$.S);const c=s["s-rc"];if(e){g(t)}const i=l("render",t.$.S);{W(t,n)}if(c){c.map((t=>t()));s["s-rc"]=undefined}i();o();{const n=s["s-p"];const e=()=>q(t);if(n.length===0){e()}else{Promise.all(n).then(e);t.i|=4;n.length=0}}};const W=(t,n,e)=>{try{n=n.render();{t.i&=~16}{t.i|=2}{{{T(t,n)}}}}catch(n){et(n,t.m)}return null};const q=t=>{const n=t.$.S;const e=t.m;const s=l("postUpdate",n);const o=t.j;if(!(t.i&64)){t.i|=64;{V(e)}s();{t.k(e);if(!o){H()}}}else{s()}{if(t.v){t.v();t.v=undefined}if(t.i&512){$t((()=>F(t,false)))}t.i&=~(4|512)}};const H=n=>{{V(it.documentElement)}$t((()=>m(ct,"appload",{detail:{namespace:t}})))};const I=(t,n)=>t&&t.then?t.then(n):n();const V=t=>t.classList.add("hydrated");const _=(t,n)=>Y(t).C.get(n);const z=(t,n,e,s)=>{const o=Y(t);const l=o.C.get(n);const c=o.i;const i=o.M;e=$(e,s.O[n][0]);const f=Number.isNaN(l)&&Number.isNaN(e);const r=e!==l&&!f;if((!(c&8)||l===undefined)&&r){o.C.set(n,e);if(i){if((c&(2|16))===2){F(o,false)}}}};const B=(t,n,e)=>{if(n.O){const s=Object.entries(n.O);const o=t.prototype;s.map((([t,[s]])=>{if(s&31||e&2&&s&32){Object.defineProperty(o,t,{get(){return _(this,t)},set(e){z(this,t,e,n)},configurable:true,enumerable:true})}}));if(e&1){const n=new Map;o.attributeChangedCallback=function(t,e,s){ft.jmp((()=>{const e=n.get(t);if(this.hasOwnProperty(e)){s=this[e];delete this[e]}else if(o.hasOwnProperty(e)&&typeof this[e]==="number"&&this[e]==s){return}this[e]=s===null&&typeof this[e]==="boolean"?false:s}))};t.observedAttributes=s.filter((([t,n])=>n[0]&15)).map((([t,e])=>{const s=e[1]||t;n.set(s,t);return s}))}}return t};const D=async(t,n,e,s,o)=>{if((n.i&32)===0){{n.i|=32;o=ot(e);if(o.then){const t=c();o=await o;t()}if(!o.isProxied){B(o,e,2);o.isProxied=true}const t=l("createInstance",e.S);{n.i|=8}try{new o(n)}catch(t){et(t)}{n.i&=~8}t()}if(o.style){let t=o.style;const n=v(e);if(!lt.has(n)){const s=l("registerStyles",e.S);w(n,t,!!(e.i&1));s()}}}const i=n.j;const f=()=>F(n,true);if(i&&i["s-rc"]){i["s-rc"].push(f)}else{f()}};const G=t=>{if((ft.i&1)===0){const n=Y(t);const e=n.$;const s=l("connectedCallback",e.S);if(!(n.i&1)){n.i|=1;{let e=t;while(e=e.parentNode||e.host){if(e["s-p"]){A(n,n.j=e);break}}}if(e.O){Object.entries(e.O).map((([n,[e]])=>{if(e&31&&t.hasOwnProperty(n)){const e=t[n];delete t[n];t[n]=e}}))}{D(t,n,e)}}s()}};const J=t=>{if((ft.i&1)===0){Y(t)}};const K=(t,n={})=>{var e;const s=l();const o=[];const c=n.exclude||[];const f=ct.customElements;const r=it.head;const u=r.querySelector("meta[charset]");const d=it.createElement("style");const h=[];let p;let y=true;Object.assign(ft,n);ft.P=new URL(n.resourcesUrl||"./",it.baseURI).href;t.map((t=>{t[1].map((n=>{const e={i:n[0],S:n[1],O:n[2],U:n[3]};{e.O=n[2]}const s=e.S;const l=class extends HTMLElement{constructor(t){super(t);t=this;tt(t,e);if(e.i&1){{{t.attachShadow({mode:"open"})}}}}connectedCallback(){if(p){clearTimeout(p);p=null}if(y){h.push(this)}else{ft.jmp((()=>G(this)))}}disconnectedCallback(){ft.jmp((()=>J(this)))}componentOnReady(){return Y(this).N}};e.T=t[0];if(!c.includes(s)&&!f.get(s)){o.push(s);f.define(s,B(l,e,1))}}))}));{d.innerHTML=o+i;d.setAttribute("data-styles","");const t=(e=ft.p)!==null&&e!==void 0?e:a(it);if(t!=null){d.setAttribute("nonce",t)}r.insertBefore(d,u?u.nextSibling:r.firstChild)}y=false;if(h.length){h.map((t=>t.connectedCallback()))}else{{ft.jmp((()=>p=setTimeout(H,30)))}}s()};const Q=t=>ft.p=t;const X=new WeakMap;const Y=t=>X.get(t);const Z=(t,n)=>X.set(n.M=t,n);const tt=(t,n)=>{const e={i:0,m:t,$:n,C:new Map};{e.N=new Promise((t=>e.k=t));t["s-p"]=[];t["s-rc"]=[]}return X.set(t,e)};const nt=(t,n)=>n in t;const et=(t,n)=>(0,console.error)(t,n);const st=new Map;const ot=(t,n,e)=>{const s=t.S.replace(/-/g,"_");const o=t.T;const l=st.get(o);if(l){return l[s]}
/*!__STENCIL_STATIC_IMPORT_SWITCH__*/return import(`./${o}.entry.js${""}`).then((t=>{{st.set(o,t)}return t[s]}),et)};const lt=new Map;const ct=typeof window!=="undefined"?window:{};const it=ct.document||{head:{}};const ft={i:0,P:"",jmp:t=>t(),raf:t=>requestAnimationFrame(t),ael:(t,n,e,s)=>t.addEventListener(n,e,s),rel:(t,n,e,s)=>t.removeEventListener(n,e,s),ce:(t,n)=>new CustomEvent(t,n)};const rt=t=>Promise.resolve(t);const ut=(()=>{try{new CSSStyleSheet;return typeof(new CSSStyleSheet).replaceSync==="function"}catch(t){}return false})();const at=[];const dt=[];const ht=(t,n)=>e=>{t.push(e);if(!o){o=true;if(n&&ft.i&4){$t(yt)}else{ft.raf(yt)}}};const pt=t=>{for(let n=0;n<t.length;n++){try{t[n](performance.now())}catch(t){et(t)}}t.length=0};const yt=()=>{pt(at);{pt(dt);if(o=at.length>0){ft.raf(yt)}}};const $t=t=>rt().then(t);const mt=ht(dt,true);export{K as b,d as h,rt as p,Z as r,Q as s};
//# sourceMappingURL=p-751e1ec3.js.map