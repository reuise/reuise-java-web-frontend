package dev.reuise.web.frontend;
import dev.reuise.core.RootComponent;
import dev.reuise.core.accordion.CoreAccordionItemOptions;
import dev.reuise.core.accordion.CoreAccordionOptions;
import dev.reuise.core.applayout.CoreAppLayoutBodyOptions;
import dev.reuise.core.applayout.CoreAppLayoutOptions;
import dev.reuise.core.avatar.CoreAvatarOptions;
import dev.reuise.core.badge.CoreBadgeOptions;
import dev.reuise.core.banner.CoreBannerOptions;
import dev.reuise.core.basecomponent.CoreBaseComponentPartOptions;
import dev.reuise.core.bottomappbar.CoreBottomAppBarOptions;
import dev.reuise.core.button.CoreButtonOptions;
import dev.reuise.core.button.CoreIconButtonOptions;
import dev.reuise.core.card.CoreCardGridOptions;
import dev.reuise.core.card.CoreCardOptions;
import dev.reuise.core.chat.CoreChatBoxOptions;
import dev.reuise.core.checkbox.CoreBasicCheckboxOptions;
import dev.reuise.core.checkbox.CoreCheckboxOptions;
import dev.reuise.core.chip.CoreChipGroupOptions;
import dev.reuise.core.chip.CoreChipOptions;
import dev.reuise.core.chip.CoreFilterChipOptions;
import dev.reuise.core.consent.CoreConsentBannerOptions;
import dev.reuise.core.currencyselector.CoreCurrencySelectorOptions;
import dev.reuise.core.dialog.CoreDialogOptions;
import dev.reuise.core.dialog.CoreMessageDialogOptions;
import dev.reuise.core.divider.CoreDividerOptions;
import dev.reuise.core.drawer.CoreDrawerOptions;
import dev.reuise.core.dropzone.CoreDropZoneOptions;
import dev.reuise.core.floating.CoreFloatingActionButtonOptions;
import dev.reuise.core.floating.CoreFloatingPanelOptions;
import dev.reuise.core.icon.CoreIconOptions;
import dev.reuise.core.image.CoreImageOptions;
import dev.reuise.core.input.CoreBasicInputFieldOptions;
import dev.reuise.core.input.CoreChipFieldOptions;
import dev.reuise.core.input.CoreMultiEmailAddressFieldOptions;
import dev.reuise.core.input.CorePasswordFieldOptions;
import dev.reuise.core.input.CoreSearchFieldOptions;
import dev.reuise.core.input.CoreSegmentedTextFieldOptions;
import dev.reuise.core.input.CoreTextFieldOptions;
import dev.reuise.core.layout.CoreColumnLayoutOptions;
import dev.reuise.core.layout.CoreContainerOptions;
import dev.reuise.core.layout.CoreFieldSetOptions;
import dev.reuise.core.layout.CoreFlexContainerOptions;
import dev.reuise.core.layout.CoreRowLayoutOptions;
import dev.reuise.core.layout.CoreSheetLayoutOptions;
import dev.reuise.core.layout.CoreSurfaceOptions;
import dev.reuise.core.link.CoreLinkOptions;
import dev.reuise.core.link.CoreNavigationLinkOptions;
import dev.reuise.core.list.CoreBasicListItemOptions;
import dev.reuise.core.list.CoreBasicListOptions;
import dev.reuise.core.list.CoreListItemOptions;
import dev.reuise.core.list.CoreListViewOptions;
import dev.reuise.core.media.CoreAudioPlayerOptions;
import dev.reuise.core.media.CoreMediaPlayerOptions;
import dev.reuise.core.media.CoreTextTrackOptions;
import dev.reuise.core.media.CoreVideoPlayerOptions;
import dev.reuise.core.menu.CoreMenuButtonItemOptions;
import dev.reuise.core.menu.CoreMenuButtonOptions;
import dev.reuise.core.menu.CoreMenuDividerOptions;
import dev.reuise.core.menu.CoreMenuItemOptions;
import dev.reuise.core.menu.CoreMenuOptions;
import dev.reuise.core.navigation.CoreNavigationTreeGroupOptions;
import dev.reuise.core.navigation.CoreNavigationTreeLinkOptions;
import dev.reuise.core.navigation.CoreNavigationTreeOptions;
import dev.reuise.core.parentcomponent.CoreParentComponentPartOptions;
import dev.reuise.core.progressindicator.CoreProgressIndicatorOptions;
import dev.reuise.core.regionselector.CoreRegionSelectorOptions;
import dev.reuise.core.scrollablecontainer.CoreScrollableContainerEdgeOptions;
import dev.reuise.core.scrollablecontainer.CoreScrollableContainerOptions;
import dev.reuise.core.scrollablecontainer.CoreScrollableContainerScrollAreaOptions;
import dev.reuise.core.selectmenu.CoreSelectMenuOptions;
import dev.reuise.core.skeleton.CoreSkeletonOptions;
import dev.reuise.core.slidecontainer.CoreSlideContainerEdgeOptions;
import dev.reuise.core.slidecontainer.CoreSlideContainerOptions;
import dev.reuise.core.splitcontainer.CoreSplitContainerDividerOptions;
import dev.reuise.core.splitcontainer.CoreSplitContainerOptions;
import dev.reuise.core.splitcontainer.CoreSplitContainerPanelOptions;
import dev.reuise.core.table.CoreCheckboxTableCellOptions;
import dev.reuise.core.table.CoreCheckboxTableColumnOptions;
import dev.reuise.core.table.CoreTableBodyOptions;
import dev.reuise.core.table.CoreTableCellOptions;
import dev.reuise.core.table.CoreTableColumnGroupOptions;
import dev.reuise.core.table.CoreTableColumnOptions;
import dev.reuise.core.table.CoreTableFooterOptions;
import dev.reuise.core.table.CoreTableHeaderCellOptions;
import dev.reuise.core.table.CoreTableHeaderOptions;
import dev.reuise.core.table.CoreTableHeaderRowOptions;
import dev.reuise.core.table.CoreTableOptions;
import dev.reuise.core.table.CoreTableRowOptions;
import dev.reuise.core.tabs.CoreTabBarOptions;
import dev.reuise.core.tabs.CoreTabOptions;
import dev.reuise.core.text.CoreHeadingOptions;
import dev.reuise.core.text.CoreIconLabelOptions;
import dev.reuise.core.text.CoreInlineTextOptions;
import dev.reuise.core.text.CoreLabelOptions;
import dev.reuise.core.text.CoreLineBreakOptions;
import dev.reuise.core.text.CoreParagraphOptions;
import dev.reuise.core.text.CoreRotatingTextOptions;
import dev.reuise.core.text.CoreTextBlockOptions;
import dev.reuise.core.text.CoreTextOptions;
import dev.reuise.core.topappbar.CoreTopAppBarOptions;
import dev.reuise.core.view.CoreSheetViewOptions;
import dev.reuise.core.view.CoreViewOptions;
import dev.reuise.web.core.WebComponentFactory;
import dev.reuise.web.core.document.WebDocumentBodyOptions;
import dev.reuise.web.core.document.WebDocumentOptions;
import dev.reuise.web.core.filepicker.WebFilePickerOptions;
import dev.reuise.web.core.graphics.svg.WebSvgGroupOptions;
import dev.reuise.web.core.graphics.svg.WebSvgImageOptions;
import dev.reuise.web.core.graphics.svg.WebSvgOptions;
import dev.reuise.web.core.graphics.svg.WebSvgPathOptions;
import dev.reuise.web.core.graphics.svg.WebSvgRectOptions;
import dev.reuise.web.core.graphics.svg.WebSvgShapeOptions;
import dev.reuise.web.core.graphics.svg.WebSvgTextOptions;
import dev.reuise.web.core.scriptcomponent.WebScriptComponentOptions;
import dev.reuise.web.core.view.WebRouteLayoutOptions;
import dev.reuise.web.core.view.WebSheetRouteLayoutOptions;
import dev.reuise.web.frontend.accordion.WebFrontendAccordion;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionItem;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionItemOptions;
import dev.reuise.web.frontend.accordion.WebFrontendAccordionOptions;
import dev.reuise.web.frontend.applayout.WebFrontendAppLayout;
import dev.reuise.web.frontend.applayout.WebFrontendAppLayoutBody;
import dev.reuise.web.frontend.applayout.WebFrontendAppLayoutBodyOptions;
import dev.reuise.web.frontend.applayout.WebFrontendAppLayoutOptions;
import dev.reuise.web.frontend.avatar.WebFrontendAvatar;
import dev.reuise.web.frontend.avatar.WebFrontendAvatarOptions;
import dev.reuise.web.frontend.badge.WebFrontendBadge;
import dev.reuise.web.frontend.badge.WebFrontendBadgeOptions;
import dev.reuise.web.frontend.banner.WebFrontendBanner;
import dev.reuise.web.frontend.banner.WebFrontendBannerOptions;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponent;
import dev.reuise.web.frontend.basecomponent.WebFrontendBaseComponentOptions;
import dev.reuise.web.frontend.bottomappbar.WebFrontendBottomAppBar;
import dev.reuise.web.frontend.bottomappbar.WebFrontendBottomAppBarOptions;
import dev.reuise.web.frontend.button.WebFrontendButton;
import dev.reuise.web.frontend.button.WebFrontendButtonOptions;
import dev.reuise.web.frontend.button.WebFrontendIconButton;
import dev.reuise.web.frontend.button.WebFrontendIconButtonOptions;
import dev.reuise.web.frontend.card.WebFrontendCard;
import dev.reuise.web.frontend.card.WebFrontendCardGrid;
import dev.reuise.web.frontend.card.WebFrontendCardGridOptions;
import dev.reuise.web.frontend.card.WebFrontendCardOptions;
import dev.reuise.web.frontend.chat.WebFrontendChatBox;
import dev.reuise.web.frontend.chat.WebFrontendChatBoxOptions;
import dev.reuise.web.frontend.checkbox.WebFrontendBasicCheckbox;
import dev.reuise.web.frontend.checkbox.WebFrontendBasicCheckboxOptions;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckbox;
import dev.reuise.web.frontend.checkbox.WebFrontendCheckboxOptions;
import dev.reuise.web.frontend.chip.WebFrontendChip;
import dev.reuise.web.frontend.chip.WebFrontendChipGroup;
import dev.reuise.web.frontend.chip.WebFrontendChipGroupOptions;
import dev.reuise.web.frontend.chip.WebFrontendChipOptions;
import dev.reuise.web.frontend.chip.WebFrontendFilterChip;
import dev.reuise.web.frontend.chip.WebFrontendFilterChipOptions;
import dev.reuise.web.frontend.consent.WebFrontendConsentBanner;
import dev.reuise.web.frontend.consent.WebFrontendConsentBannerOptions;
import dev.reuise.web.frontend.currencyselector.WebFrontendCurrencySelector;
import dev.reuise.web.frontend.currencyselector.WebFrontendCurrencySelectorOptions;
import dev.reuise.web.frontend.dialog.WebFrontendDialog;
import dev.reuise.web.frontend.dialog.WebFrontendDialogOptions;
import dev.reuise.web.frontend.dialog.WebFrontendMessageDialog;
import dev.reuise.web.frontend.dialog.WebFrontendMessageDialogOptions;
import dev.reuise.web.frontend.divider.WebFrontendDivider;
import dev.reuise.web.frontend.divider.WebFrontendDividerOptions;
import dev.reuise.web.frontend.document.WebFrontendDocument;
import dev.reuise.web.frontend.document.WebFrontendDocumentBody;
import dev.reuise.web.frontend.document.WebFrontendDocumentBodyOptions;
import dev.reuise.web.frontend.document.WebFrontendDocumentOptions;
import dev.reuise.web.frontend.document.WebFrontendDocumentWithModel;
import dev.reuise.web.frontend.document.WebFrontendDocumentWithModelOptions;
import dev.reuise.web.frontend.drawer.WebFrontendDrawer;
import dev.reuise.web.frontend.drawer.WebFrontendDrawerOptions;
import dev.reuise.web.frontend.dropzone.WebFrontendDropZone;
import dev.reuise.web.frontend.dropzone.WebFrontendDropZoneOptions;
import dev.reuise.web.frontend.filepicker.WebFrontendFilePicker;
import dev.reuise.web.frontend.filepicker.WebFrontendFilePickerOptions;
import dev.reuise.web.frontend.floating.WebFrontendFloatingActionButton;
import dev.reuise.web.frontend.floating.WebFrontendFloatingActionButtonOptions;
import dev.reuise.web.frontend.floating.WebFrontendFloatingPanel;
import dev.reuise.web.frontend.floating.WebFrontendFloatingPanelOptions;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvg;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgGroup;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgGroupOptions;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgImage;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgImageOptions;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgOptions;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgPath;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgPathOptions;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgRect;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgRectOptions;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgShape;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgShapeOptions;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgText;
import dev.reuise.web.frontend.graphics.svg.WebFrontendSvgTextOptions;
import dev.reuise.web.frontend.icon.WebFrontendIcon;
import dev.reuise.web.frontend.icon.WebFrontendIconOptions;
import dev.reuise.web.frontend.image.WebFrontendImage;
import dev.reuise.web.frontend.image.WebFrontendImageOptions;
import dev.reuise.web.frontend.input.WebFrontendBasicInputField;
import dev.reuise.web.frontend.input.WebFrontendBasicInputFieldOptions;
import dev.reuise.web.frontend.input.WebFrontendChipField;
import dev.reuise.web.frontend.input.WebFrontendChipFieldOptions;
import dev.reuise.web.frontend.input.WebFrontendMultiEmailAddressField;
import dev.reuise.web.frontend.input.WebFrontendMultiEmailAddressFieldOptions;
import dev.reuise.web.frontend.input.WebFrontendPasswordField;
import dev.reuise.web.frontend.input.WebFrontendPasswordFieldOptions;
import dev.reuise.web.frontend.input.WebFrontendSearchField;
import dev.reuise.web.frontend.input.WebFrontendSearchFieldOptions;
import dev.reuise.web.frontend.input.WebFrontendSegmentedTextField;
import dev.reuise.web.frontend.input.WebFrontendSegmentedTextFieldOptions;
import dev.reuise.web.frontend.input.WebFrontendTextField;
import dev.reuise.web.frontend.input.WebFrontendTextFieldOptions;
import dev.reuise.web.frontend.layout.WebFrontendColumnLayout;
import dev.reuise.web.frontend.layout.WebFrontendColumnLayoutOptions;
import dev.reuise.web.frontend.layout.WebFrontendContainer;
import dev.reuise.web.frontend.layout.WebFrontendContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendFieldSet;
import dev.reuise.web.frontend.layout.WebFrontendFieldSetOptions;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainer;
import dev.reuise.web.frontend.layout.WebFrontendFlexContainerOptions;
import dev.reuise.web.frontend.layout.WebFrontendRowLayout;
import dev.reuise.web.frontend.layout.WebFrontendRowLayoutOptions;
import dev.reuise.web.frontend.layout.WebFrontendSheetLayout;
import dev.reuise.web.frontend.layout.WebFrontendSheetLayoutOptions;
import dev.reuise.web.frontend.layout.WebFrontendSurface;
import dev.reuise.web.frontend.layout.WebFrontendSurfaceOptions;
import dev.reuise.web.frontend.link.WebFrontendLink;
import dev.reuise.web.frontend.link.WebFrontendLinkOptions;
import dev.reuise.web.frontend.link.WebFrontendNavigationLink;
import dev.reuise.web.frontend.link.WebFrontendNavigationLinkOptions;
import dev.reuise.web.frontend.list.WebFrontendBasicList;
import dev.reuise.web.frontend.list.WebFrontendBasicListItem;
import dev.reuise.web.frontend.list.WebFrontendBasicListItemOptions;
import dev.reuise.web.frontend.list.WebFrontendBasicListOptions;
import dev.reuise.web.frontend.list.WebFrontendListItem;
import dev.reuise.web.frontend.list.WebFrontendListItemOptions;
import dev.reuise.web.frontend.list.WebFrontendListView;
import dev.reuise.web.frontend.list.WebFrontendListViewOptions;
import dev.reuise.web.frontend.media.WebFrontendAudioPlayer;
import dev.reuise.web.frontend.media.WebFrontendAudioPlayerOptions;
import dev.reuise.web.frontend.media.WebFrontendMediaPlayer;
import dev.reuise.web.frontend.media.WebFrontendMediaPlayerOptions;
import dev.reuise.web.frontend.media.WebFrontendTextTrack;
import dev.reuise.web.frontend.media.WebFrontendTextTrackOptions;
import dev.reuise.web.frontend.media.WebFrontendVideoPlayer;
import dev.reuise.web.frontend.media.WebFrontendVideoPlayerOptions;
import dev.reuise.web.frontend.menu.WebFrontendMenu;
import dev.reuise.web.frontend.menu.WebFrontendMenuButton;
import dev.reuise.web.frontend.menu.WebFrontendMenuButtonItem;
import dev.reuise.web.frontend.menu.WebFrontendMenuButtonItemOptions;
import dev.reuise.web.frontend.menu.WebFrontendMenuButtonOptions;
import dev.reuise.web.frontend.menu.WebFrontendMenuDivider;
import dev.reuise.web.frontend.menu.WebFrontendMenuDividerOptions;
import dev.reuise.web.frontend.menu.WebFrontendMenuItem;
import dev.reuise.web.frontend.menu.WebFrontendMenuItemOptions;
import dev.reuise.web.frontend.menu.WebFrontendMenuOptions;
import dev.reuise.web.frontend.navigation.WebFrontendNavigationTree;
import dev.reuise.web.frontend.navigation.WebFrontendNavigationTreeGroup;
import dev.reuise.web.frontend.navigation.WebFrontendNavigationTreeGroupOptions;
import dev.reuise.web.frontend.navigation.WebFrontendNavigationTreeLink;
import dev.reuise.web.frontend.navigation.WebFrontendNavigationTreeLinkOptions;
import dev.reuise.web.frontend.navigation.WebFrontendNavigationTreeOptions;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponent;
import dev.reuise.web.frontend.parentcomponent.WebFrontendParentComponentOptions;
import dev.reuise.web.frontend.progressindicator.WebFrontendProgressIndicator;
import dev.reuise.web.frontend.progressindicator.WebFrontendProgressIndicatorOptions;
import dev.reuise.web.frontend.regionselector.WebFrontendRegionSelector;
import dev.reuise.web.frontend.regionselector.WebFrontendRegionSelectorOptions;
import dev.reuise.web.frontend.scriptcomponent.WebFrontendScriptComponent;
import dev.reuise.web.frontend.scriptcomponent.WebFrontendScriptComponentOptions;
import dev.reuise.web.frontend.scrollablecontainer.WebFrontendScrollableContainer;
import dev.reuise.web.frontend.scrollablecontainer.WebFrontendScrollableContainerEdge;
import dev.reuise.web.frontend.scrollablecontainer.WebFrontendScrollableContainerEdgeOptions;
import dev.reuise.web.frontend.scrollablecontainer.WebFrontendScrollableContainerOptions;
import dev.reuise.web.frontend.scrollablecontainer.WebFrontendScrollableContainerScrollArea;
import dev.reuise.web.frontend.scrollablecontainer.WebFrontendScrollableContainerScrollAreaOptions;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenu;
import dev.reuise.web.frontend.selectmenu.WebFrontendSelectMenuOptions;
import dev.reuise.web.frontend.skeleton.WebFrontendSkeleton;
import dev.reuise.web.frontend.skeleton.WebFrontendSkeletonOptions;
import dev.reuise.web.frontend.slidecontainer.WebFrontendSlideContainer;
import dev.reuise.web.frontend.slidecontainer.WebFrontendSlideContainerEdge;
import dev.reuise.web.frontend.slidecontainer.WebFrontendSlideContainerEdgeOptions;
import dev.reuise.web.frontend.slidecontainer.WebFrontendSlideContainerOptions;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainer;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerDivider;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerDividerOptions;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerOptions;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerPanel;
import dev.reuise.web.frontend.splitcontainer.WebFrontendSplitContainerPanelOptions;
import dev.reuise.web.frontend.table.WebFrontendCheckboxTableCell;
import dev.reuise.web.frontend.table.WebFrontendCheckboxTableCellOptions;
import dev.reuise.web.frontend.table.WebFrontendCheckboxTableColumn;
import dev.reuise.web.frontend.table.WebFrontendCheckboxTableColumnOptions;
import dev.reuise.web.frontend.table.WebFrontendTable;
import dev.reuise.web.frontend.table.WebFrontendTableBody;
import dev.reuise.web.frontend.table.WebFrontendTableBodyOptions;
import dev.reuise.web.frontend.table.WebFrontendTableCell;
import dev.reuise.web.frontend.table.WebFrontendTableCellOptions;
import dev.reuise.web.frontend.table.WebFrontendTableColumn;
import dev.reuise.web.frontend.table.WebFrontendTableColumnGroup;
import dev.reuise.web.frontend.table.WebFrontendTableColumnGroupOptions;
import dev.reuise.web.frontend.table.WebFrontendTableColumnOptions;
import dev.reuise.web.frontend.table.WebFrontendTableFooter;
import dev.reuise.web.frontend.table.WebFrontendTableFooterOptions;
import dev.reuise.web.frontend.table.WebFrontendTableHeader;
import dev.reuise.web.frontend.table.WebFrontendTableHeaderCell;
import dev.reuise.web.frontend.table.WebFrontendTableHeaderCellOptions;
import dev.reuise.web.frontend.table.WebFrontendTableHeaderOptions;
import dev.reuise.web.frontend.table.WebFrontendTableHeaderRow;
import dev.reuise.web.frontend.table.WebFrontendTableHeaderRowOptions;
import dev.reuise.web.frontend.table.WebFrontendTableOptions;
import dev.reuise.web.frontend.table.WebFrontendTableRow;
import dev.reuise.web.frontend.table.WebFrontendTableRowOptions;
import dev.reuise.web.frontend.tabs.WebFrontendTab;
import dev.reuise.web.frontend.tabs.WebFrontendTabBar;
import dev.reuise.web.frontend.tabs.WebFrontendTabBarOptions;
import dev.reuise.web.frontend.tabs.WebFrontendTabOptions;
import dev.reuise.web.frontend.text.WebFrontendHeading;
import dev.reuise.web.frontend.text.WebFrontendHeadingOptions;
import dev.reuise.web.frontend.text.WebFrontendIconLabel;
import dev.reuise.web.frontend.text.WebFrontendIconLabelOptions;
import dev.reuise.web.frontend.text.WebFrontendInlineText;
import dev.reuise.web.frontend.text.WebFrontendInlineTextOptions;
import dev.reuise.web.frontend.text.WebFrontendLabel;
import dev.reuise.web.frontend.text.WebFrontendLabelOptions;
import dev.reuise.web.frontend.text.WebFrontendLineBreak;
import dev.reuise.web.frontend.text.WebFrontendLineBreakOptions;
import dev.reuise.web.frontend.text.WebFrontendParagraph;
import dev.reuise.web.frontend.text.WebFrontendParagraphOptions;
import dev.reuise.web.frontend.text.WebFrontendRotatingText;
import dev.reuise.web.frontend.text.WebFrontendRotatingTextOptions;
import dev.reuise.web.frontend.text.WebFrontendText;
import dev.reuise.web.frontend.text.WebFrontendTextBlock;
import dev.reuise.web.frontend.text.WebFrontendTextBlockOptions;
import dev.reuise.web.frontend.text.WebFrontendTextOptions;
import dev.reuise.web.frontend.topappbar.WebFrontendTopAppBar;
import dev.reuise.web.frontend.topappbar.WebFrontendTopAppBarOptions;
import dev.reuise.web.frontend.view.WebFrontendRouteLayout;
import dev.reuise.web.frontend.view.WebFrontendRouteLayoutOptions;
import dev.reuise.web.frontend.view.WebFrontendSheetRouteLayout;
import dev.reuise.web.frontend.view.WebFrontendSheetRouteLayoutOptions;
import dev.reuise.web.frontend.view.WebFrontendSheetView;
import dev.reuise.web.frontend.view.WebFrontendSheetViewOptions;
import dev.reuise.web.frontend.view.WebFrontendView;
import dev.reuise.web.frontend.view.WebFrontendViewOptions;
public interface WebFrontendComponentFactory extends WebComponentFactory {
    WebFrontendTableHeaderRow createTableHeaderRow(CoreTableHeaderRowOptions options);

    WebFrontendTableHeaderRowOptions createTableHeaderRowOptions();

    WebFrontendNavigationTree createNavigationTree(CoreNavigationTreeOptions options);

    WebFrontendNavigationTreeOptions createNavigationTreeOptions();

    WebFrontendMessageDialog createMessageDialog(CoreMessageDialogOptions options);

    WebFrontendMessageDialogOptions createMessageDialogOptions();

    WebFrontendSlideContainer createSlideContainer(CoreSlideContainerOptions options);

    WebFrontendSlideContainerOptions createSlideContainerOptions();

    WebFrontendIcon createIcon(CoreIconOptions options);

    WebFrontendIconOptions createIconOptions();

    WebFrontendLink createLink(CoreLinkOptions options);

    WebFrontendLinkOptions createLinkOptions();

    WebFrontendLineBreak createLineBreak(CoreLineBreakOptions options);

    WebFrontendLineBreakOptions createLineBreakOptions();

    WebFrontendTab createTab(CoreTabOptions options);

    WebFrontendTabOptions createTabOptions();

    WebFrontendCheckbox createCheckbox(CoreCheckboxOptions options);

    WebFrontendCheckboxOptions createCheckboxOptions();

    WebFrontendDrawer createDrawer(CoreDrawerOptions options);

    WebFrontendDrawerOptions createDrawerOptions();

    WebFrontendSheetLayout createSheetLayout(CoreSheetLayoutOptions options);

    WebFrontendSheetLayoutOptions createSheetLayoutOptions();

    WebFrontendSheetRouteLayout createSheetRouteLayout(WebSheetRouteLayoutOptions options);

    WebFrontendSheetRouteLayoutOptions createSheetRouteLayoutOptions();

    WebFrontendTableColumn createTableColumn(CoreTableColumnOptions options);

    WebFrontendTableColumnOptions createTableColumnOptions();

    WebFrontendMenuButton createMenuButton(CoreMenuButtonOptions options);

    WebFrontendMenuButtonOptions createMenuButtonOptions();

    WebFrontendCardGrid createCardGrid(CoreCardGridOptions options);

    WebFrontendCardGridOptions createCardGridOptions();

    WebFrontendInlineText createInlineText(CoreInlineTextOptions options);

    WebFrontendInlineTextOptions createInlineTextOptions();

    WebFrontendSplitContainer createSplitContainer(CoreSplitContainerOptions options);

    WebFrontendSplitContainerOptions createSplitContainerOptions();

    WebFrontendBasicList createBasicList(CoreBasicListOptions options);

    WebFrontendBasicListOptions createBasicListOptions();

    WebFrontendChipField createChipField(CoreChipFieldOptions options);

    WebFrontendChipFieldOptions createChipFieldOptions();

    WebFrontendTextField createTextField(CoreTextFieldOptions options);

    WebFrontendTextFieldOptions createTextFieldOptions();

    WebFrontendAppLayout createAppLayout(CoreAppLayoutOptions options);

    WebFrontendAppLayoutOptions createAppLayoutOptions();

    WebFrontendMenuButtonItem createMenuButtonItem(CoreMenuButtonItemOptions options);

    WebFrontendMenuButtonItemOptions createMenuButtonItemOptions();

    WebFrontendContainer createContainer(CoreContainerOptions options);

    WebFrontendContainerOptions createContainerOptions();

    WebFrontendTableHeaderCell createTableHeaderCell(CoreTableHeaderCellOptions options);

    WebFrontendTableHeaderCellOptions createTableHeaderCellOptions();

    WebFrontendButton createButton(CoreButtonOptions options);

    WebFrontendButtonOptions createButtonOptions();

    WebFrontendFlexContainer createFlexContainer(CoreFlexContainerOptions options);

    WebFrontendFlexContainerOptions createFlexContainerOptions();

    WebFrontendAccordionItem createAccordionItem(CoreAccordionItemOptions options);

    WebFrontendAccordionItemOptions createAccordionItemOptions();

    WebFrontendParentComponent createParentComponent(CoreParentComponentPartOptions options);

    WebFrontendParentComponentOptions createParentComponentOptions();

    WebFrontendNavigationTreeGroup createNavigationTreeGroup(CoreNavigationTreeGroupOptions options);

    WebFrontendNavigationTreeGroupOptions createNavigationTreeGroupOptions();

    WebFrontendSplitContainerPanel createSplitContainerPanel(CoreSplitContainerPanelOptions options);

    WebFrontendSplitContainerPanelOptions createSplitContainerPanelOptions();

    WebFrontendTable createTable(CoreTableOptions options);

    WebFrontendTableOptions createTableOptions();

    WebFrontendTableFooter createTableFooter(CoreTableFooterOptions options);

    WebFrontendTableFooterOptions createTableFooterOptions();

    WebFrontendTableHeader createTableHeader(CoreTableHeaderOptions options);

    WebFrontendTableHeaderOptions createTableHeaderOptions();

    WebFrontendTableRow createTableRow(CoreTableRowOptions options);

    WebFrontendTableRowOptions createTableRowOptions();

    WebFrontendScrollableContainerEdge createScrollableContainerEdge(CoreScrollableContainerEdgeOptions options);

    WebFrontendScrollableContainerEdgeOptions createScrollableContainerEdgeOptions();

    WebFrontendAppLayoutBody createAppLayoutBody(CoreAppLayoutBodyOptions options);

    WebFrontendAppLayoutBodyOptions createAppLayoutBodyOptions();

    WebFrontendChipGroup createChipGroup(CoreChipGroupOptions options);

    WebFrontendChipGroupOptions createChipGroupOptions();

    WebFrontendSearchField createSearchField(CoreSearchFieldOptions options);

    WebFrontendSearchFieldOptions createSearchFieldOptions();

    WebFrontendImage createImage(CoreImageOptions options);

    WebFrontendImageOptions createImageOptions();

    WebFrontendTableColumnGroup createTableColumnGroup(CoreTableColumnGroupOptions options);

    WebFrontendTableColumnGroupOptions createTableColumnGroupOptions();

    WebFrontendDivider createDivider(CoreDividerOptions options);

    WebFrontendDividerOptions createDividerOptions();

    WebFrontendCheckboxTableCell createCheckboxTableCell(CoreCheckboxTableCellOptions options);

    WebFrontendCheckboxTableCellOptions createCheckboxTableCellOptions();

    WebFrontendIconButton createIconButton(CoreIconButtonOptions options);

    WebFrontendIconButtonOptions createIconButtonOptions();

    WebFrontendSelectMenu createSelectMenu(CoreSelectMenuOptions options);

    WebFrontendSelectMenuOptions createSelectMenuOptions();

    WebFrontendConsentBanner createConsentBanner(CoreConsentBannerOptions options);

    WebFrontendConsentBannerOptions createConsentBannerOptions();

    WebFrontendCheckboxTableColumn createCheckboxTableColumn(CoreCheckboxTableColumnOptions options);

    WebFrontendCheckboxTableColumnOptions createCheckboxTableColumnOptions();

    WebFrontendMenu createMenu(CoreMenuOptions options);

    WebFrontendMenuOptions createMenuOptions();

    WebFrontendSvg createSvg(WebSvgOptions options);

    WebFrontendSvgOptions createSvgOptions();

    WebFrontendDocument createDocument(WebDocumentOptions options);

    WebFrontendDocumentOptions createDocumentOptions();

    WebFrontendRotatingText createRotatingText(CoreRotatingTextOptions options);

    WebFrontendRotatingTextOptions createRotatingTextOptions();

    WebFrontendSplitContainerDivider createSplitContainerDivider(CoreSplitContainerDividerOptions options);

    WebFrontendSplitContainerDividerOptions createSplitContainerDividerOptions();

    WebFrontendCurrencySelector createCurrencySelector(CoreCurrencySelectorOptions options);

    WebFrontendCurrencySelectorOptions createCurrencySelectorOptions();

    WebFrontendTopAppBar createTopAppBar(CoreTopAppBarOptions options);

    WebFrontendTopAppBarOptions createTopAppBarOptions();

    WebFrontendFloatingActionButton createFloatingActionButton(CoreFloatingActionButtonOptions options);

    WebFrontendFloatingActionButtonOptions createFloatingActionButtonOptions();

    WebFrontendSkeleton createSkeleton(CoreSkeletonOptions options);

    WebFrontendSkeletonOptions createSkeletonOptions();

    WebFrontendFieldSet createFieldSet(CoreFieldSetOptions options);

    WebFrontendFieldSetOptions createFieldSetOptions();

    WebFrontendRouteLayout createRouteLayout(WebRouteLayoutOptions options);

    WebFrontendRouteLayoutOptions createRouteLayoutOptions();

    WebFrontendSvgPath createSvgPath(WebSvgPathOptions options);

    WebFrontendSvgPathOptions createSvgPathOptions();

    WebFrontendView createView(CoreViewOptions options);

    WebFrontendViewOptions createViewOptions();

    WebFrontendCard createCard(CoreCardOptions options);

    WebFrontendCardOptions createCardOptions();

    WebFrontendFilePicker createFilePicker(WebFilePickerOptions options);

    WebFrontendFilePickerOptions createFilePickerOptions();

    WebFrontendChip createChip(CoreChipOptions options);

    WebFrontendChipOptions createChipOptions();

    WebFrontendProgressIndicator createProgressIndicator(CoreProgressIndicatorOptions options);

    WebFrontendProgressIndicatorOptions createProgressIndicatorOptions();

    WebFrontendSegmentedTextField createSegmentedTextField(CoreSegmentedTextFieldOptions options);

    WebFrontendSegmentedTextFieldOptions createSegmentedTextFieldOptions();

    WebFrontendRowLayout createRowLayout(CoreRowLayoutOptions options);

    WebFrontendRowLayoutOptions createRowLayoutOptions();

    WebFrontendBanner createBanner(CoreBannerOptions options);

    WebFrontendBannerOptions createBannerOptions();

    WebFrontendScrollableContainerScrollArea createScrollableContainerScrollArea(CoreScrollableContainerScrollAreaOptions options);

    WebFrontendScrollableContainerScrollAreaOptions createScrollableContainerScrollAreaOptions();

    WebFrontendRegionSelector createRegionSelector(CoreRegionSelectorOptions options);

    WebFrontendRegionSelectorOptions createRegionSelectorOptions();

    WebFrontendSvgGroup createSvgGroup(WebSvgGroupOptions options);

    WebFrontendSvgGroupOptions createSvgGroupOptions();

    WebFrontendSvgRect createSvgRect(WebSvgRectOptions options);

    WebFrontendSvgRectOptions createSvgRectOptions();

    WebFrontendMenuDivider createMenuDivider(CoreMenuDividerOptions options);

    WebFrontendMenuDividerOptions createMenuDividerOptions();

    WebFrontendBottomAppBar createBottomAppBar(CoreBottomAppBarOptions options);

    WebFrontendBottomAppBarOptions createBottomAppBarOptions();

    WebFrontendTableCell createTableCell(CoreTableCellOptions options);

    WebFrontendTableCellOptions createTableCellOptions();

    WebFrontendMultiEmailAddressField createMultiEmailAddressField(CoreMultiEmailAddressFieldOptions options);

    WebFrontendMultiEmailAddressFieldOptions createMultiEmailAddressFieldOptions();

    WebFrontendTextTrack createTextTrack(CoreTextTrackOptions options);

    WebFrontendTextTrackOptions createTextTrackOptions();

    WebFrontendBadge createBadge(CoreBadgeOptions options);

    WebFrontendBadgeOptions createBadgeOptions();

    WebFrontendPasswordField createPasswordField(CorePasswordFieldOptions options);

    WebFrontendPasswordFieldOptions createPasswordFieldOptions();

    WebFrontendSurface createSurface(CoreSurfaceOptions options);

    WebFrontendSurfaceOptions createSurfaceOptions();

    WebFrontendSvgImage createSvgImage(WebSvgImageOptions options);

    WebFrontendSvgImageOptions createSvgImageOptions();

    WebFrontendLabel createLabel(CoreLabelOptions options);

    WebFrontendLabelOptions createLabelOptions();

    WebFrontendMediaPlayer createMediaPlayer(CoreMediaPlayerOptions options);

    WebFrontendMediaPlayerOptions createMediaPlayerOptions();

    WebFrontendSlideContainerEdge createSlideContainerEdge(CoreSlideContainerEdgeOptions options);

    WebFrontendSlideContainerEdgeOptions createSlideContainerEdgeOptions();

    WebFrontendColumnLayout createColumnLayout(CoreColumnLayoutOptions options);

    WebFrontendColumnLayoutOptions createColumnLayoutOptions();

    WebFrontendDropZone createDropZone(CoreDropZoneOptions options);

    WebFrontendDropZoneOptions createDropZoneOptions();

    WebFrontendTabBar createTabBar(CoreTabBarOptions options);

    WebFrontendTabBarOptions createTabBarOptions();

    WebFrontendListItem createListItem(CoreListItemOptions options);

    WebFrontendListItemOptions createListItemOptions();

    WebFrontendAudioPlayer createAudioPlayer(CoreAudioPlayerOptions options);

    WebFrontendAudioPlayerOptions createAudioPlayerOptions();

    WebFrontendAvatar createAvatar(CoreAvatarOptions options);

    WebFrontendAvatarOptions createAvatarOptions();

    WebFrontendText createText(CoreTextOptions options);

    WebFrontendTextOptions createTextOptions();

    WebFrontendMenuItem createMenuItem(CoreMenuItemOptions options);

    WebFrontendMenuItemOptions createMenuItemOptions();

    WebFrontendDocumentBody createDocumentBody(WebDocumentBodyOptions options);

    WebFrontendDocumentBodyOptions createDocumentBodyOptions();

    WebFrontendBasicInputField createBasicInputField(CoreBasicInputFieldOptions options);

    WebFrontendBasicInputFieldOptions createBasicInputFieldOptions();

    WebFrontendBaseComponent createBaseComponent(CoreBaseComponentPartOptions options);

    WebFrontendBaseComponentOptions createBaseComponentOptions();

    WebFrontendNavigationTreeLink createNavigationTreeLink(CoreNavigationTreeLinkOptions options);

    WebFrontendNavigationTreeLinkOptions createNavigationTreeLinkOptions();

    WebFrontendBasicListItem createBasicListItem(CoreBasicListItemOptions options);

    WebFrontendBasicListItemOptions createBasicListItemOptions();

    WebFrontendSvgShape createSvgShape(WebSvgShapeOptions options);

    WebFrontendSvgShapeOptions createSvgShapeOptions();

    WebFrontendSheetView createSheetView(CoreSheetViewOptions options);

    WebFrontendSheetViewOptions createSheetViewOptions();

    WebFrontendAccordion createAccordion(CoreAccordionOptions options);

    WebFrontendAccordionOptions createAccordionOptions();

    WebFrontendSvgText createSvgText(WebSvgTextOptions options);

    WebFrontendSvgTextOptions createSvgTextOptions();

    WebFrontendChatBox createChatBox(CoreChatBoxOptions options);

    WebFrontendChatBoxOptions createChatBoxOptions();

    WebFrontendVideoPlayer createVideoPlayer(CoreVideoPlayerOptions options);

    WebFrontendVideoPlayerOptions createVideoPlayerOptions();

    WebFrontendListView createListView(CoreListViewOptions options);

    WebFrontendListViewOptions createListViewOptions();

    WebFrontendFilterChip createFilterChip(CoreFilterChipOptions options);

    WebFrontendFilterChipOptions createFilterChipOptions();

    WebFrontendBasicCheckbox createBasicCheckbox(CoreBasicCheckboxOptions options);

    WebFrontendBasicCheckboxOptions createBasicCheckboxOptions();

    WebFrontendTableBody createTableBody(CoreTableBodyOptions options);

    WebFrontendTableBodyOptions createTableBodyOptions();

    WebFrontendScriptComponent createScriptComponent(WebScriptComponentOptions options);

    WebFrontendScriptComponentOptions createScriptComponentOptions();

    WebFrontendFloatingPanel createFloatingPanel(CoreFloatingPanelOptions options);

    WebFrontendFloatingPanelOptions createFloatingPanelOptions();

    WebFrontendDialog createDialog(CoreDialogOptions options);

    WebFrontendDialogOptions createDialogOptions();

    WebFrontendIconLabel createIconLabel(CoreIconLabelOptions options);

    WebFrontendIconLabelOptions createIconLabelOptions();

    WebFrontendTextBlock createTextBlock(CoreTextBlockOptions options);

    WebFrontendTextBlockOptions createTextBlockOptions();

    WebFrontendParagraph createParagraph(CoreParagraphOptions options);

    WebFrontendParagraphOptions createParagraphOptions();

    WebFrontendScrollableContainer createScrollableContainer(CoreScrollableContainerOptions options);

    WebFrontendScrollableContainerOptions createScrollableContainerOptions();

    WebFrontendDocumentWithModel createDocumentWithModel(WebFrontendDocumentWithModelOptions options);

    WebFrontendDocumentWithModelOptions createDocumentWithModelOptions();

    WebFrontendHeading createHeading(CoreHeadingOptions options);

    WebFrontendHeadingOptions createHeadingOptions();

    WebFrontendNavigationLink createNavigationLink(CoreNavigationLinkOptions options);

    WebFrontendNavigationLinkOptions createNavigationLinkOptions();

    void setRootComponent(RootComponent rootComponent);

    RootComponent getRootComponent();
}
