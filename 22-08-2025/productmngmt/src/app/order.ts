export interface OrderRequest {
  productId: number;
  qty: number;
}

export interface OrderResponse {
  id: number;
  productName: string;
  qty: number;
  orderDate: Date | string;
}
