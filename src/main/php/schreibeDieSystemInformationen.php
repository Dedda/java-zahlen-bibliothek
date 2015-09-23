<?php

require_once(__DIR__.'/libidoContext.php');

$kontext = libido\libidoContext::getInstance();
$kontext->gebeSystemInformationen();