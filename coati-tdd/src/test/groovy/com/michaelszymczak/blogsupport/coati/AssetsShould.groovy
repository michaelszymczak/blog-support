package com.michaelszymczak.blogsupport.coati

import spock.lang.Specification

class AssetsShould extends Specification {

  def "add shares to the existing assets"() {
    given:
    def assets = Assets.of([new CompanyShares(new Ticker("FOO"), 5)])

    expect:
    assets.withAdditional([new CompanyShares(new Ticker("BAR"), 4)]) == Assets.of([
            new CompanyShares(new Ticker("FOO"), 5),
            new CompanyShares(new Ticker("BAR"), 4),
    ])
  }
}
