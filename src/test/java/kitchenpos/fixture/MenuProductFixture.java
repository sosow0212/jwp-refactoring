package kitchenpos.fixture;

import kitchenpos.domain.MenuProduct;

public class MenuProductFixture {

    public static MenuProduct 메뉴_상품_10개_생성(final Long menuId, final Long productId) {
        return new MenuProduct(menuId, productId, 10);
    }
}
