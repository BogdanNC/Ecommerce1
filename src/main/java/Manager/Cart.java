package Manager;

import java.util.UUID;

public class Cart {
    public String cartID;

    public String getCartID() {
        return cartID;
    }

    private static String  generateRandomCartID() {
        UUID uuid = UUID.randomUUID();
        // TODO check DB to not have this UUID already
        return uuid.toString();
    }

    // Create a new cart - TODO it will become private once getNewOrExistingCart function is done
    public String createCart() {
        Cart cart = new Cart();
        this.cartID = generateRandomCartID();
        return cart.getCartID();
    }

    public String getNewOrExistingCart(String ID) {
        if (ID == null || ID.isEmpty()) {
            //check profile DB for cart ID
        }
        if (cartID == null || cartID.isEmpty()) { // this should check the profile DB, or should receive from cookies a cart ID. If it exists in Cart DB, it should build a cart based on that info
            createCart();
        }

        return cartID;
    }
}
