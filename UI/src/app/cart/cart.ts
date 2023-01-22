import { Product } from "../products/products";
import { User } from "../user-register/user";

export class Cart {
    id?: number;
    price?: number;
    quantity?: number;
    user?: User;
    product?: Product;
}
