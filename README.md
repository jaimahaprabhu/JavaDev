# Angular

Bulma css, semantic-ui.com --> css  npm install semantic-ui-css / bulma / bootstrap
app.component.html = component template  contains HTML
app.component.ts=component class contains code to run when events occurs
translate.service.ts=service contains code do crud ops
app.module.ts=Module defines set of services + components that handle all functionality for a part of our app
---
Commands:
ng new <appname>  --> create angular app
ng new Components --routing --> with routing
npm start   or ng serve   --> execute angular app
ng generate component <name> --> create new component  ng g c
ng generate pipe <name> --> create custom pipe
ng genearte directive <name> --> create custom directive 
ng genearte module <name> --routing( if need) --> create module.  ng g m 
ng generate component elements/ElementsHome. --> create component inside a module
ng generate service <name> --> cretae angular service ng g s
---
Event-Binding: <button (click)="onButtonClick()">  => onButtonClick is user function , click is the event we looking for.
Property-Binding: <input [value]="attributename"/> => attribute is binded to the value.
Interpolation: {{attrnameORfunName()}} => Print info in template, can access any attribute or function from component class into template.
$any() type-cast function  to opt out of type-checking for a part of the expression e.g any($event).taget.value
---
angular.io/api?type=directive
structural directives := add/remove html elements eg: <div *ngIf="condition" >, <comp *ngFor="let p of postarray">
attribute directives := changes properties of html elements
[ngClass]="{key:value}" => based on value true/false , the key/class will be assigned to the element., or  call function as. [ngClass]="getFun()"
const classes=[]; // {"":""} --> refers to an object
classes.push(''); // rerurning array of classess will handled by ngclass.
for a single element <> there can only be one *ng directive
<ng-container> :=  used to hold directives without creating an HTML element. recognized by the Angular parser. It's not a directive, component, class, or interface. It's more like the curly braces in a JavaScript.
https://codeburst.io/angular-interview-question-what-are-ng-container-ng-content-and-ng-template-9fafbbc255d5
[ngSwitch]="", *ngSwitchCase=""
---
Components := wraps up a html code to make a widget, all ang apps made of multiple different components.
can be reused and nested, each component has own template ,css, class and spec files. 'App' component is parent component
---
for @Input and @Output
@Input - a decorator to mark  input property, to achieve property binding.  @Output , a decorator to mark output property, to achieve event binding.
 @Input and @Output can define alias for property names as @Input(alias) and @Output(alias).
https://www.concretepage.com/angular-2/angular-2-input-and-output-example
---
:host - refers to current/host element for css styling, as app-root can't be access in app-comp-css, only in style.css.  :host:not(:first-of-type){

Pipes => Functions that format data for use in a template.angular.io/api?type=pipe. 
---
Modules :=  All Angular apps have at least one module - the App Module. Used to group together similar components, directives, and pipes in Angular





Angular provides us some default modules (http, form handling)
---
Routing :== 
<a routerlink="path"> === <a href="path"> to avoid reload of application  if a path changes

Lazy Loading := 

<ng-content> :=

any and never := 
<router-outlet> := Acts as a placeholder that Angular dynamically fills based on the current router state. A router outlet emits an activate event when a new component is instantiated, deactivate event when a component is destroyed.
 relative path==> / -  root, ./ - current path, ../ - previous path, ./path - add next to current simply as giving path

ElementRef :=  to access host element , to change css prop. document.body.appendChild(this.hostelement.nativeElement);
---
LifecycleHooks ==> 

event emit and event bubbling:=

stoppropagtion() to avoid event bubbling.

package.json => records all the dependencies that to be install for that project , creating cmd := npm init -y,  npm install typescript ts-node.

name : any => :(int/any) is type annotation

undefined vs null vs any
type inference := Thanks will figure out type of variable, if we declare and assign a var in single line . includes() method in js.
arrow function :=
---
decorator :=  plain function executes whenever our class is executed by typescript. has 2 arguments as param. called when file is first executed not when instance is created. can be applied to a class, a property , a method,  an accessor, argument of method. Receive different args depending on when it get used.
can be plain decorator or decorator factory. decorator factory means decorator with parentheses which return a function.

Generic class := <T> , also function generics <T>(x:T):T[] => {}
// every <input> inside <form> for every hit the enter key will trigger summit event in the wrap eg .<form (submit)="">
https://www.stackoverflow.com/questions/67123603/angular-error-ts2531-object-is-possibly-null

child to parent :=  eventEmitter ,output decorator   
---
Services := used to fetch/store/update any kind of data in out app, useful for network requests, data flows from service to component.
implemented as class. angular automatically creates single instance of service

constructor( private wiki:AnyServiceClass ) {} => private property of wiki of type <AnyServiceClass> will created automatically when instance is created for that component.

Injector /Container := an object store references of to all the things that are able to injected as dependencies into our component.


---
APP-Security : &amp; = & , &lt; = < , &gt; = > 

- <a target="_blank" href="xxx"></a> ==> opens in new tab
- to style a html coming from innerHtml (eg. <p [innerHTML]="codecnippetfromTS"/>) , need to add style in global style css file.
---
Rx-Js := Functional Reactive ProgrammingLibrary.


- Observables := are the elements which emits events to consume.
- Operators := take a value through event object and  do a kind of transform it or something and then passes to  next operator or next processing step.
- Assembling operators into pipeline processing. called as pipe.
- Observer := Possibilites (successs/failure) of processed data is combined and called as observer.


One-way and Two-way Data Binding in Angular
https://www.pluralsight.com/guides/one-and-two-way-data-binding-angular


Angular Data Binding
https://malcoded.com/posts/angular-data-binding/
https://blog.thoughtram.io/angular/2016/10/13/two-way-data-binding-in-angular-2.html

angular pipe upper and lower example
https://www.concretepage.com/angular-2/angular-2-uppercase-pipe-and-lowercase-pipe-example

angular medium blog
https://blog.bitsrc.io/tagged/angular
https://stackoverflow.com/questions/51615237/what-does-mean-in-angular-5

https://blog.angulartraining.com/fake-your-angular-backend-until-you-make-it-8d145f713e14







