package com.luxoft.bankapp.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Client {

	private String name;
	private Gender gender;

	private Set<Account> accounts = new HashSet<Account>();

	public Client(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	public void addAccount(final Account account) {
		accounts.add(account);
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Set<Account> getAccounts() {
		return Collections.unmodifiableSet(accounts);
	}

	public String getClientGreeting() {
		if (gender != null) {
			return gender.getGreeting() + " " + name;
		} else {
			return name;
		}
	}

	@Override
	public String toString() {
		return getClientGreeting();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		return name != null ? name.equals(client.name) : client.name == null;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}
}
