package com.michaelszymczak.blogsupport.coati

import spock.lang.Specification

class AssetsShould extends Specification {

  def "should be comparable based on shares"() {
    given:
    def assets = Assets.of([new CompanyShares(new Ticker("FOO"), 5)])

    expect:
    assets == Assets.of([new CompanyShares(new Ticker("FOO"), 5)])
    assets != Assets.of([new CompanyShares(new Ticker("FOO"), 4)])
    assets != Assets.of([new CompanyShares(new Ticker("BAR"), 5)])
  }

  def "add shares to the existing assets"() {
    given:
    def assets = Assets.of([new CompanyShares(new Ticker("FOO"), 5)])

    expect:
    assets.withAdditional([new CompanyShares(new Ticker("BAR"), 4)]) == Assets.of([
            new CompanyShares(new Ticker("FOO"), 5),
            new CompanyShares(new Ticker("BAR"), 4),
    ])
  }

  def "group shares of the same company together"() {
    given:
    def assets = Assets.of([new CompanyShares(new Ticker("FOO"), 5)])

    expect:
    assets.withAdditional([new CompanyShares(new Ticker("FOO"), 6)]) == Assets.of([
            new CompanyShares(new Ticker("FOO"), 11)
    ])
  }
}
