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
    echo $gesamterArbeitsspeicher;
    echo $freierArbeitsspeicher;
    echo $verfügbarerArbeitsspeicher;
    echo $gesamterEinhandelspeicher;
    echo $freierEinhandelspeicher;
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
