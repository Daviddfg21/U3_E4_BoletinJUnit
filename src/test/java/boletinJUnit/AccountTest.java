package boletinJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void testDeposit() {
		Account account = new Account("David Flores", 123456, 1000);

		assertTrue(account.deposit(500));
		assertEquals(1500, account.getBalance());

		assertFalse(account.deposit(-200));
		assertEquals(1500, account.getBalance()); // Balance no debería haber cambiado
	}

	@Test
	void testWithdraw() {
		Account account = new Account("Manuel Díaz", 789012, 2000);

		assertTrue(account.withdraw(1000, 50));
		assertEquals(950, account.getBalance());

		assertFalse(account.withdraw(-200, 20));
		assertEquals(950, account.getBalance()); // Balance no debería haber cambiado

		assertFalse(account.withdraw(1000, 1000));
		assertEquals(950, account.getBalance()); // Balance no debería haber cambiado
	}

	@Test
	void testAddInterest() {
		Account account = new Account("Paco", 111222, 3000);
		account.addInterest();
		assertEquals(3000 + (3000 * 0.045f), account.getBalance(), 0.001);
	}

	@Test
	void testToString() {
		Account account = new Account("Mohamed", 333444, 500);
		String expectedString = "333444\tBob\t$500.00";
		assertEquals(expectedString, account.toString());
	}

	@Test
	void testWithdrawWithInvalidFee() {
		Account account = new Account("Test", 123456, 100.0f);
		assertFalse(account.withdraw(50.0f, -5.0f));
		assertFalse(account.withdraw(50.0f, 105.0f));
		assertEquals(100.0f, account.getBalance(), 0.01);
	}

	@Test
	void testWithdrawWithValidFee() {
		Account account = new Account("Test", 123456, 100.0f);
		assertTrue(account.withdraw(50.0f, 5.0f));
		assertEquals(45.0f, account.getBalance(), 0.01);
	}

	@Test
	void testWithdrawExceedingBalance() {
		Account account = new Account("Test", 123456, 100.0f);
		assertFalse(account.withdraw(150.0f, 5.0f));
		assertEquals(100.0f, account.getBalance(), 0.01);
	}

	@Test
	void testWithdrawExactBalance() {
		Account account = new Account("Test", 123456, 100.0f);
		assertTrue(account.withdraw(100.0f, 0.0f));
		assertEquals(0.0f, account.getBalance(), 0.01);
	}
}
