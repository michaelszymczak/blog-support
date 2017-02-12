package com.michaelszymczak.blogsupport.coati;

import org.joda.money.Money;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableMap.copyOf;

public class StockMarket extends Value {

  Map<String,ListedCompany> listedCompanies;

  public StockMarket(List<ListedCompany> listedCompanies) {
    this.listedCompanies = copyOf(listedCompanies.stream().collect(Collectors.toMap(
            ListedCompany::ticker,
            Function.identity()
    )));
  }

  public static StockMarket listing(List<ListedCompany> listedCompanies) {
    return new StockMarket(listedCompanies);
  }

  public Money priceOf(String companyWithTicker) {
    return listedCompanies.get(companyWithTicker).pricePerShare();
  }

  public Money priceOf(CompanyShares shares) {
    return priceOf(shares.ticker()).multipliedBy(shares.howMany());
  }
}
