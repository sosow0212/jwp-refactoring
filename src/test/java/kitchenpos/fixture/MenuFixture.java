package kitchenpos.fixture;

import kitchenpos.application.menu.dto.MenuCreateRequest;
import kitchenpos.application.menu.dto.MenuProductCreateRequest;
import kitchenpos.domain.Menu;
import kitchenpos.domain.MenuGroup;
import kitchenpos.domain.MenuProduct;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("NonAsciiCharacters")
public class MenuFixture {

    public static Menu 메뉴_생성(final String name,
                             final Long price,
                             final MenuGroup menuGroup) {
        return new Menu(null, name, price, menuGroup);
    }

    public static MenuCreateRequest 메뉴_생성_요청(
            final String name,
            final Long price,
            final Long menuGroupId,
            final List<MenuProductCreateRequest> menuProductCreateRequests
    ) {
        return new MenuCreateRequest(name,
                price,
                menuGroupId,
                menuProductCreateRequests
        );
    }

    public static MenuCreateRequest 메뉴_생성_요청(final String name,
                                             final Long price,
                                             final MenuGroup menuGroup,
                                             final List<MenuProduct> menuProducts) {
        List<MenuProductCreateRequest> menuProductCreateRequests = menuProducts.stream()
                .map(it -> new MenuProductCreateRequest(it.getProduct().getId(), it.getQuantity()))
                .collect(Collectors.toList());

        return new MenuCreateRequest(
                name,
                price,
                menuGroup.getId(),
                menuProductCreateRequests
        );
    }
}
