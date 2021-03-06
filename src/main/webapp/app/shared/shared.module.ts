import { NgModule } from '@angular/core';
import { SecuredImageComponent } from 'app/shared/image/secured-image.component';
import { ArtemisSharedPipesModule } from 'app/shared/pipes/shared-pipes.module';
import { DeleteDialogComponent } from 'app/shared/delete-dialog/delete-dialog.component';
import { DeleteButtonDirective } from 'app/shared/delete-dialog/delete-button.directive';
import { ResizeableContainerComponent } from './resizeable-container/resizeable-container.component';
import { SecureLinkDirective } from 'app/shared/http/secure-link.directive';
import { ArtemisSharedCommonModule } from 'app/shared/shared-common.module';

import { HasAnyAuthorityDirective } from 'app/shared/auth/has-any-authority.directive';
import { FindLanguageFromKeyPipe } from 'app/shared/language/find-language-from-key.pipe';
import { ArtemisSharedLibsModule } from 'app/shared/shared-libs.module';
import { SlideToggleComponent } from 'app/exercises/shared/slide-toggle/slide-toggle.component';
import { AlertErrorComponent } from 'app/shared/alert/alert-error.component';
import { JhiConnectionStatusComponent } from 'app/shared/connection-status/connection-status.component';
import { ArtemisDatePipe } from 'app/shared/pipes/artemis-date.pipe';
import { ArtemisDurationFromSecondsPipe } from 'app/shared/pipes/artemis-duration-from-seconds.pipe';
import { ChartComponent } from 'app/shared/chart/chart.component';
import { AlertComponent } from 'app/shared/alert/alert.component';
import { CircularProgressBarComponent } from 'app/shared/circular-progress-bar/circular-progress-bar.component';
import { CustomMinDirective } from 'app/shared/validators/custom-min-validator.directive';
import { CustomMaxDirective } from 'app/shared/validators/custom-max-validator.directive';

@NgModule({
    imports: [ArtemisSharedLibsModule, ArtemisSharedCommonModule, ArtemisSharedPipesModule],
    declarations: [
        ArtemisDatePipe,
        CircularProgressBarComponent,
        ArtemisDurationFromSecondsPipe,
        HasAnyAuthorityDirective,
        SecuredImageComponent,
        DeleteDialogComponent,
        DeleteButtonDirective,
        ResizeableContainerComponent,
        SecureLinkDirective,
        SlideToggleComponent,
        JhiConnectionStatusComponent,
        ChartComponent,
        CustomMinDirective,
        CustomMaxDirective,
    ],
    entryComponents: [DeleteDialogComponent],
    exports: [
        ArtemisDatePipe,
        ArtemisDurationFromSecondsPipe,
        ArtemisSharedLibsModule,
        CircularProgressBarComponent,
        FindLanguageFromKeyPipe,
        AlertComponent,
        AlertErrorComponent,
        HasAnyAuthorityDirective,
        ArtemisSharedCommonModule,
        ArtemisSharedPipesModule,
        SecuredImageComponent,
        DeleteButtonDirective,
        DeleteDialogComponent,
        ResizeableContainerComponent,
        SecureLinkDirective,
        SlideToggleComponent,
        JhiConnectionStatusComponent,
        ChartComponent,
        CustomMinDirective,
        CustomMaxDirective,
    ],
    providers: [ArtemisDatePipe],
})
export class ArtemisSharedModule {}
