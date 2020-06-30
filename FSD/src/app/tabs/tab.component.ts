/**
 * A single tab page. It renders the passed template
 * via the @Input properties by using the ngTemplateOutlet
 * and ngTemplateOutletContext directives.
 */

import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-my-tab',
  styles: [
    `
    .pane{
      padding: 1em;
    }
  `
  ],
  template: `
      <div *ngIf="active" class="pane">
        <!--<div class="pane">-->
      <ng-content></ng-content>
    </div>
  `
})
export class TabComponent {
  @Input() active = false;
  @Input() tabTitle: string;

}
