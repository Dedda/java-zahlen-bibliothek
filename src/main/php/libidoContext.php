<?php

namespace libido;

class libidoContext
{

  public static function getInstance()
  {
    return new self();
  }

  private function __construct()
  {

  }

  public function gebeSystemInformationen()
  {
    $gesamterArbeitsspeicher = $this->bekommeDenGesamtenArbeitsspeicher();
    $freierArbeitsspeicher = $this->bekommeDenFreienArbeitsspeicher();
    $verfügbarerArbeitsspeicher = $this->bekommeDenVerfügbarenArbeitsspeicher();
    $gesamterEinhandelspeicher = $this->bekommeDenGesamtenEinhandelspeicher();
    $freierEinhandelspeicher = $this->bekommeDenFreienEinhandelspeicher();
    $megahertze = $this->bekommeDieMegaHertze();
    $kerne = $this->bekommeDieKerne();
    $zentralerProzessionsEinheitsNamen = $this->bekommeDenZentralenProzessionsEinheitsNamen();
    $flaggen = $this->bekommeDieFlaggen();
    $käfigGröße = $this->bekommeDieKäfigGröße();
    echo $gesamterArbeitsspeicher.PHP_EOL;
    echo $freierArbeitsspeicher.PHP_EOL;
    echo $verfügbarerArbeitsspeicher.PHP_EOL;
    echo $gesamterEinhandelspeicher.PHP_EOL;
    echo $freierEinhandelspeicher.PHP_EOL;
    echo $megahertze.PHP_EOL;
    echo $kerne.PHP_EOL;
    echo $zentralerProzessionsEinheitsNamen.PHP_EOL;
    echo $flaggen.PHP_EOL;
    echo $käfigGröße.PHP_EOL;
  }

  private function bekommeDenGesamtenArbeitsspeicher()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/arbeitsspeicherInformationen.sh gesamt', true);
    $explodiert = explode(' ', $befehlsAusgabe[0]);
    return $explodiert[1];
  }

  private function bekommeDenFreienArbeitsspeicher()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/arbeitsspeicherInformationen.sh frei', true);
    $explodiert = explode(' ', $befehlsAusgabe[0]);
    return $explodiert[1];
  }

  private function bekommeDenVerfügbarenArbeitsspeicher()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/arbeitsspeicherInformationen.sh verfügbar', true);
    $explodiert = explode(' ', $befehlsAusgabe[0]);
    return $explodiert[1];
  }

  private function bekommeDenGesamtenEinhandelspeicher()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/arbeitsspeicherInformationen.sh einhandeln gesamt', true);
    $explodiert = explode(' ', $befehlsAusgabe[0]);
    return $explodiert[1];
  }

  private function bekommeDenFreienEinhandelspeicher()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/arbeitsspeicherInformationen.sh einhandeln frei', true);
    $explodiert = explode(' ', $befehlsAusgabe[0]);
    return $explodiert[1];
  }

  private function bekommeDieMegaHertze()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/zentraleProzessionsEinheitInformationen.sh megahertze', true);
    $explodiert = explode(':', $befehlsAusgabe[0]);
    return trim($explodiert[1]);
  }

  private function bekommeDieKerne()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/zentraleProzessionsEinheitInformationen.sh kerne', true);
    $kerne = 0;
    foreach ($befehlsAusgabe as $ausgabeEinheit) {
      $explodiert = explode(':', $ausgabeEinheit);
      $explodiert = trim($explodiert[1]);
      if ($kerne < $explodiert) {
        $kerne = $explodiert;
      }
    }
    return $kerne+1;
  }

  private function bekommeDenZentralenProzessionsEinheitsNamen()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/zentraleProzessionsEinheitInformationen.sh name', true);
    $explodiert = explode(':', $befehlsAusgabe[0]);
    return trim($explodiert[1]);
  }

  private function bekommeDieFlaggen()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/zentraleProzessionsEinheitInformationen.sh flaggen', true);
    $explodiert = explode(':', $befehlsAusgabe[0]);
    return trim($explodiert[1]);
  }

  private function bekommeDieKäfigGröße()
  {
    $befehlsAusgabe = $this->führeBefehlAus(__DIR__.'/../sh/zentraleProzessionsEinheitInformationen.sh käfig', true);
    $explodiert = explode(':', $befehlsAusgabe[0]);
    return trim($explodiert[1]);
  }

  private function führeBefehlAus($befehl, $überflüssigeLeerzeichenEntfernen = false)
  {
    $ausgabe = array();
    exec($befehl, $ausgabe);
    if ($überflüssigeLeerzeichenEntfernen) {
      for ($i = 0; $i < count($ausgabe); $i++) {
        while (strpos($ausgabe[$i], "  ")) {
          $ausgabe[$i] = str_replace("  ", " ", $ausgabe[$i]);
        }
      }
    }
    return $ausgabe;
  }

}

?>
