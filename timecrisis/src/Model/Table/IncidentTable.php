<?php
namespace App\Model\Table;

use Cake\ORM\Table;

class IncidentTable extends Table
{

    public function initialize(array $config)
    {
        $this->table('Incident');
    }

}
