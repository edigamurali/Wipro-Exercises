import { CurrencyPipe } from './currency.pipe';

describe('CurrencyPipe', () => {
  let pipe: CurrencyPipe;

  beforeEach(() => {
    pipe = new CurrencyPipe();
  });

  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  it('should format currency correctly', () => {
    expect(pipe.transform(100)).toBe('₹100.00');
    expect(pipe.transform(1234.56)).toBe('₹1,234.56');
    expect(pipe.transform(null)).toBe('₹0.00');
  });
});
