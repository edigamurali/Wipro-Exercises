export interface CartItem {
  id?: number;
  userId: number;
  productId: number;
  quantity: number;
  productName?: string;
  productImage?: string;
  productPrice?: number;
}
